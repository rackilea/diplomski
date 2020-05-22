if (bitmap == null) {
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(Color.CYAN);
    canvas.drawRect(mImagePosition, paint);
    return;
}
Rect rect = new Rect(0, 0, this.getWidth(), this.getHeight());
canvas.drawBitmap(bitmap, rect, mImagePosition, null);