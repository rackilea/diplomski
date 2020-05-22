@Override
protected void onDraw(Canvas canvas) {

    paint.setColor(Color.RED);
    canvas.drawBitmap(size, 0, 0, paint);
    canvas.drawBitmap( mBitmap, 0, 0, mBitmapPaint);
    canvas.drawPath( mPath,  mPaint);
    canvas.drawPath( circlePath,  circlePaint);
}