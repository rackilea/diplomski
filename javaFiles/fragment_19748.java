public static Bitmap mergeImages(Bitmap bottomImage, Bitmap topImage) {
    final Bitmap output = Bitmap.createBitmap(bottomImage.getWidth(), bottomImage
            .getHeight(), Config.ARGB_8888);
    final Canvas canvas = new Canvas(output);
    final Paint paint = new Paint();
    paint.setAntiAlias(true);

    canvas.drawBitmap(bottomImage, 0, 0, paint);
    canvas.drawBitmap(topImage, 0, 0, paint);

    return output;
}