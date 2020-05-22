package com.example.myapplication;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RoundedCornerLayout extends FrameLayout {

    private Path path = new Path();

    public RoundedCornerLayout(Context context) {
        super(context);
    }

    public RoundedCornerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundedCornerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // compute the path
        float halfWidth = w / 2f;
        float halfHeight = h / 2f;
        float centerX = halfWidth;
        float centerY = halfHeight;
        path.reset();
        path.addCircle(centerX, centerY, Math.min(halfWidth, halfHeight), Path.Direction.CW);
        path.close();

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }
}