private void drawPirate(Canvas c) {
        setToFrame(i);
        i++;
        if (i == 120) {
            i = 0;
        }
        Matrix matrix = new Matrix();
        c.scale(mScaleX, mScaleY);
        c.drawBitmap(mainBitmap, matrix, null);
}