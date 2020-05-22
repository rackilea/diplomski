Bitmap sourceBitmap = BitmapFactory... 

float[] colorTransform = .. // read ColorMatrix docs to understand the transform
ColorMatrix colorMatrix = new ColorMatrix();

ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
Paint paint = new Paint();
paint.setColorFilter(colorFilter);         

Bitmap resultBitmap = Bitmap.createBitmap(
     sourceBitmap.getWidth(), 
     sourceBitmap.getHeight(),
     Bitmap.Config.RGB_565);

 Canvas canvas = new Canvas(resultBitmap);
 canvas.drawBitmap(sourceBitmap, 0, 0, paint);

int pixelColor=resultBitmap.getPixel(123,321);