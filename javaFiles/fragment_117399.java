private void drawCanvas() {
    Canvas c = mHolder.lockCanvas();
    c.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

    Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.imagenamefromdrawableRes);
    c.drawBitmap(bmp, mBallX, mBallY - RADIUS, null);
    //c.drawCircle(mBallX, mBallY, RADIUS, paint);
    mHolder.unlockCanvasAndPost(c);
}