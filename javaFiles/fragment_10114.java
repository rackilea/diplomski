package com.android.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class Animation extends View
{
Bitmap gBall;
float changingY;

public Animation(Context content)
{
    super(content);

    gBall = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
    changingY = 0;
}

@Override
protected void onDraw(Canvas canvas)
{
    super.onDraw(canvas);
    canvas.drawColor(Color.BLACK);
    canvas.drawBitmap(gBall, (canvas.getWidth()/2), changingY, null);
    if(changingY < canvas.getHeight())
        changingY += 10;
    else
        changingY = 0;

    invalidate();
}
}