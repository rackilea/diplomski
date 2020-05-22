public Drawable createFromView(int positionNumber) {
 LayoutInflater inflater = (LayoutInflater)
 context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 View view = inflater.inflate(R.drawable.pin_icon, null, false);
 TextView tv = (TextView)
 view.findViewById(R.id.pin_background);
 tv.setText("     " + (positionNumber + 1));
 tv.setDrawingCacheEnabled(true);
 tv.layout(0, 0, 50, 50);
 tv.buildDrawingCache();
 Bitmap b = Bitmap.createBitmap(tv.getDrawingCache());
 tv.setDrawingCacheEnabled(false);
 Drawable d = new BitmapDrawable(b);
 return d;
}

//Or convert view into bitmap

private Bitmap getBitmapFromView(View view) {
 //Define a bitmap with the same size as the view
 Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(),
  view.getHeight(), Bitmap.Config.ARGB_8888);
 //Bind a canvas to it
 Canvas canvas = new Canvas(returnedBitmap);
 //Get the view's background
 Drawable bgDrawable = view.getBackground();
 if (bgDrawable != null) {
  //has background drawable, then draw it on the canvas
  bgDrawable.draw(canvas);
 } else {
  //does not have background drawable, then draw white 
  background on the canvas
  canvas.drawColor(Color.WHITE);
 }
 // draw the view on the canvas
 view.draw(canvas);
 //return the bitmap
 return returnedBitmap;
}