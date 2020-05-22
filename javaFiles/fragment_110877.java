public static Bitmap getBitmapFromView(View view) {
    Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(returnedBitmap);
    Drawable bgDrawable =view.getBackground();
    if (bgDrawable!=null) 
        bgDrawable.draw(canvas);
    else 
        canvas.drawColor(Color.WHITE);
    view.draw(canvas);
    return returnedBitmap;
}