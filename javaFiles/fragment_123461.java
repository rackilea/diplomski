int x = 0;
int y = 0;
for (int i=0; i<array.length; i++) {
  Bitmap bmp = BitmapFactory.decodeResource(getResources(), array1[i]);            
  canvas.drawBitmap(bmp, x, y, null);
  x += bmp.getWidth();
}