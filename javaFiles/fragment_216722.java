Bitmap mField = null;

void init()
{
  mField = new Bitmap(...dimensions...);
  Canvas c = new Canvas(mField);
  c.drawRect(...);
  ...
}

void onDraw(Canvas c)
{
  c.drawBitmap(mField);
}