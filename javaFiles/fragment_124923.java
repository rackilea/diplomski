public void clear()
{
  mBitmapPaint = new Paint(Paint.DITHER_FLAG);
  mBitmap = Bitmap.createBitmap(320,480,Bitmap.Config.ARGB_8888);
  mCanvas = new Canvas(mBitmap);  

       //reset drawing tools. reset other drawing tools. (linepaint, cirlce paint..)        

  mPaint = new Paint();
  mPaint.setAntiAlias(true);
  mPaint.setDither(true);
  mPaint.setColor(0xFFFF0000);
  mPaint.setStyle(Paint.Style.STROKE);
  mPaint.setStrokeJoin(Paint.Join.ROUND);
  mPaint.setStrokeCap(Paint.Cap.ROUND);
  mPaint.setStrokeWidth(0);
  invalidate(); //refresh your view. try this
}