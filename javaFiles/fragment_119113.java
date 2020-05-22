public static Bitmap loadBitmapFromView(View v)
{
    Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(b);
    v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
    v.draw(c);
    return b;
}

@Override
public boolean onTouch(View v, MotionEvent event)
{
    Bitmap b = loadBitmapFromView(v);
    long color = b.getPixel((int)event.getX(), (int)event.getY());
    //check what the color is, act accordingly 
}