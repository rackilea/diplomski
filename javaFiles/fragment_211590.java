public Bitmap rotateImage(int angle, Bitmap bitmapSrc) {
    Matrix matrix = new Matrix();
    matrix.postRotate(angle);
    return Bitmap.createBitmap(bitmapSrc, 0, 0, 
        bitmapSrc.getWidth(), bitmapSrc.getHeight(), matrix, true);
}