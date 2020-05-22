BitmapFactory.Options options = new BitmapFactory.Options();

 options.inSampleSize = 4;

 Bitmap myBitmap = BitmapFactory.decodeFile(mUri.getPath(),options);
 Drawable d = new BitmapDrawable(Resources.getSystem(),myBitmap);
 updateDrawable(d);