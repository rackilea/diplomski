public static Bitmap overlay(Bitmap base, Bitmap overlay, Float percentage) {
    Bitmap resultBitmap = Bitmap.createBitmap(base.getWidth(), base.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(resultBitmap);

    Paint paint = new Paint();

    // base bitmap
    canvas.drawBitmap(base, 0F, 0F, paint);

    // overlay bitmap
    int yOffset = (int) (percentage * base.getHeight());
    Rect rect = new Rect(0, yOffset, overlay.getWidth(), overlay.getHeight());
    canvas.drawBitmap(overlay, rect, rect, paint);
    return resultBitmap;
}