private static Bitmap bmLargeImage;
bmLargeImage = BitmapFactory.decodeResource(getResources(), assignImg);
int bmWidth  = bmLargeImage.getWidth();
int bmHeight = bmLargeImage.getHeight();

displayWidth = display.getWidth();
displayHeight = display.getHeight();

if (bmWidth < displayWidth){
  displayWidth = bmWidth;
}
if (bmHeight < displayHeight){
  displayHeight = bmHeight;
}