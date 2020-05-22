@Override
public void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (downX < upX && downY < upY)
        canvas.drawRect(downX, downY, upX, upY, paint);
    else if (downX > upX && downY < upY)
        canvas.drawRect(upX, downY, downX, upY, paint);
    else if (downX < upX && downY > upY)
        canvas.drawRect(downX, upY, upX, downY, paint);
    else
        canvas.drawRect(upX, upY, downX, downY, paint);
}