Bitmap createImageThumbnail(String imagePath, int width, int height) {  
  BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();  
  bmpFactoryOptions.inJustDecodeBounds = true;  
  int heightRatio = (int) Math.ceil(bmpFactoryOptions.outHeight  
    / (float) height);  
  int widthRatio = (int) Math.ceil(bmpFactoryOptions.outWidth  
    / (float) width);  

  if (heightRatio > 1 || widthRatio > 1) {  
   if (heightRatio > widthRatio) {  
    bmpFactoryOptions.inSampleSize = heightRatio;  
   } else {  
    bmpFactoryOptions.inSampleSize = widthRatio;  
   }  
  }  
  bmpFactoryOptions.inJustDecodeBounds = false;  

  if (bitmap != null) {  
   bitmap.recycle();  
   bitmap = null;  
  }  

  bitmap = BitmapFactory.decodeFile(imagePath, bmpFactoryOptions);  
  return bitmap;  
 }