DrawView.java

package com.example.com.dibuja;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener {
private Canvas mCanvas;
private Path mPath;
public Paint mPaint;
private ArrayList<Path> paths = new ArrayList<Path>();
Bitmap bmp;

public DrawView(Context context) {
    super(context);
    setFocusable(true);
    setFocusableInTouchMode(true);

    this.setOnTouchListener(this);
    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.v01);
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setDither(true);
    mPaint.setColor(Color.BLUE);
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeJoin(Paint.Join.ROUND);
    mPaint.setStrokeCap(Paint.Cap.ROUND);
    mPaint.setStrokeWidth(6);
    mCanvas = new Canvas();
    mPath = new Path();
    paths.add(mPath);

}

@Override
protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
}

@Override
protected void onDraw(Canvas canvas) {
    canvas.drawBitmap(bmp, 0, 0, mPaint);
    for (Path p : paths) {
        canvas.drawPath(p, mPaint);
    }
}

private float mX, mY;
private static final float TOUCH_TOLERANCE = 0;
Draw dw = new Draw();

private void touch_start(float x, float y) {
    mPath.reset();
    mPath.moveTo(x, y);
    mX = x;
    mY = y;

}

private void touch_move(float x, float y) {
    float dx = Math.abs(x - mX);
    float dy = Math.abs(y - mY);
    if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
        mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
        mX = x;
        mY = y;
    }

}

private void touch_up() {
    mPath.lineTo(mX, mY);
    // commit the path to our offscreen
    mCanvas.drawPath(mPath, mPaint);
    // kill this so we don't double draw
    mPath = new Path();
    paths.add(mPath);
}

@Override
public boolean onTouch(View arg0, MotionEvent event) {
    float x = event.getX();
    float y = event.getY();

    switch (event.getAction()) {
    case MotionEvent.ACTION_DOWN:
        touch_start(x, y);
        invalidate();
        break;
    case MotionEvent.ACTION_MOVE:
        touch_move(x, y);
        invalidate();
        break;
    case MotionEvent.ACTION_UP:
        touch_up();
        invalidate();
        break;
    }
    return true;
}
}