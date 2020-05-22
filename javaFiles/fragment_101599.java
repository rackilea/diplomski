private Bitmap getDarkerBitmap(Bitmap src)
{
    final int COLOR = 0xAAFFFFFF;
    final int WIDTH = src.getWidth();
    final int HEIGHT = src.getHeight();
    final Bitmap result = Bitmap.createBitmap(WIDTH, HEIGHT, src.getConfig());

    final BitmapDrawable drawable = new BitmapDrawable(src);
    drawable.setBounds(0, 0, WIDTH, HEIGHT);
    drawable.setColorFilter(COLOR, PorterDuff.Mode.DARKEN);
    drawable.draw(new Canvas(result));

    return result;
}