public void restoreDraw () {
    drawPath = null;
    canvasBitmap = Bitmap.createBitmap(width, 350, Bitmap.Config.ARGB_8888);
    drawPath = new Path();
    requestLayout();
}