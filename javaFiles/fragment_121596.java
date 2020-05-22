@SuppressWarnings("deprecation")
public void setBackground(int id){
    Bitmap bmp = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(bmp);
    Shader shader = new BitmapShader(BitmapFactory.decodeResource(getResources(), id), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

    Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
    paint.setAntiAlias(true);
    paint.setShader(shader);
    RectF rec = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
//  you may need this for only top round corner
//  RectF rec = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight()-20);
//  c.drawRect(new RectF(0, 20, getMeasuredWidth(), getMeasuredHeight()),      paint);
    c.drawRoundRect(rec, 20, 20, paint);
    this.setBackgroundDrawable(new BitmapDrawable(getResources(), bmp));

}