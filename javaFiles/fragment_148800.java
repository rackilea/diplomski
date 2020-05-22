Bitmap bitmap = getBitmapFromView(scrollview, scrollview.getChildAt(0).getHeight(), scrollview.getChildAt(0).getWidth());

private Bitmap getBitmapFromView(View view, int height, int width) {
    Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Drawable bgDrawable = view.getBackground();
    if (bgDrawable != null)
        bgDrawable.draw(canvas);
    else
        canvas.drawColor(Color.WHITE);
    view.draw(canvas);
    return bitmap;
}