package com.blog.www.guideview;

import android.content.Context;
import android.database.DatabaseUtils;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by binIoter
 */
class Common {
    /**
     * 设置Component
     */
    static View componentToView(LayoutInflater inflater, Component c) {
        View view = c.getView(inflater);
        final MaskView.LayoutParams lp = new MaskView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.offsetX = c.getXOffset();
        lp.offsetY = c.getYOffset();
        lp.targetAnchor = c.getAnchor();
        lp.targetParentPosition = c.getFitPosition();
        view.setLayoutParams(lp);
        return view;
    }

    /**
     * Rect在屏幕上去掉状态栏高度的绝对位置
     */
    static Rect getViewAbsRect(View view, int parentX, int parentY) {
        int[] loc = new int[2];
        view.getLocationInWindow(loc);
        Rect rect = new Rect();
        rect.set(loc[0], loc[1], loc[0] + view.getMeasuredWidth(), loc[1] + view.getMeasuredHeight());
        rect.offset(-parentX, -parentY);

        return rect;
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int dip2px(Context context, float dipValue) {
        if (context == null) {
            return (int) dipValue;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
