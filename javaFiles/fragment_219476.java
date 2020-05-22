@Override
protected void onDraw(final Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawBitmap(bitmap1, 0, 0, null); // lower image
    canvas.drawBitmap(bitmap2, 0, 0, null); // upper image
}