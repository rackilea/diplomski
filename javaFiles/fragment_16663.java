List<Bitmap> list = new ArrayList<Bitmap>();

for (...) {
    Bitmap bmp = Bitmap.createBitmap(width, height, Config.ARGB_8888);
    Canvas canv = new Canvas(bmp);

    /* Draw on canvas */

    list.add(bmp);
}