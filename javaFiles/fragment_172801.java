public Bitmap addGradient(Bitmap src, int color1, int color2)
{
    int w = src.getWidth();
    int h = src.getHeight();
    Bitmap result = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(result);

    canvas.drawBitmap(src, 0, 0, null);

    Paint paint = new Paint();
    LinearGradient shader = new LinearGradient(0,0,0,h, color1, color2, Shader.TileMode.CLAMP);
    paint.setShader(shader);
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    canvas.drawRect(0,0,w,h,paint);

    return result;
}