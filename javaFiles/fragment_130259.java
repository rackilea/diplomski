public Bitmap resizeBitmap(Bitmap getBitmap, int maxSize) {
    int width = getBitmap.getWidth();
    int height = getBitmap.getHeight();
    double x;

    if (width >= height && width > maxSize) {
        x = width / height;
        width = maxSize;
        height = (int) (maxSize / x);
    } else if (height >= width && height > maxSize) {
        x = height / width;
        height = maxSize;
        width = (int) (maxSize / x);
    }
    return Bitmap.createScaledBitmap(getBitmap, width, height, false);
}