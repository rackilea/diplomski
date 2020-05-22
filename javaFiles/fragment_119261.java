private Bitmap cropBitmap() {
    int minX = mDrawnAreaRect.left <= 0 ? 0 : (int) mDrawnAreaRect.left;
    int maxY = mDrawnAreaRect.top > mBitmap.getHeight() ? mBitmap.getHeight() : (int) mDrawnAreaRect.top;
    int maxX = mDrawnAreaRect.right > mBitmap.getWidth() ? mBitmap.getWidth() : (int) mDrawnAreaRect.right;
    int minY = mDrawnAreaRect.bottom <= 0 ? 0 : (int) mDrawnAreaRect.bottom;

    int width = maxX - minX;
    int height = maxY - minY;

    width = width > mBitmap.getWidth() ? mBitmap.getWidth() : width;
    height = height > mBitmap.getHeight() ? mBitmap.getHeight() : height;

    return Bitmap.createBitmap(mBitmap, minX, minY, width, height);
}