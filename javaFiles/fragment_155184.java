final Rect rect =...
if (VERSION.SDK_INT >= VERSION_CODES.GINGERBREAD_MR1)
  {
  BitmapRegionDecoder decoder=BitmapRegionDecoder.newInstance(imageFilePath, true);
  croppedBitmap= decoder.decodeRegion(rect, null);
  decoder.recycle();
  }
else 
  {
  Bitmap bitmapOriginal=BitmapFactory.decodeFile(imageFilePath, null);
  croppedBitmap=Bitmap.createBitmap(bitmapOriginal,rect.left,rect.top,rect.width(),rect.height());
  }