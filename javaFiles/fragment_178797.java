Bitmap scaledBitmap = getResizedBitmap(BitmapFactory.decodeFile("/mnt/sdcard/Pictures/MyCameraApp/TEMP.jpg"),3,3); 
public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
    int width = bm.getWidth();
    int height = bm.getHeight();
    float scaleWidth = ((float) newWidth) / width;
    float scaleHeight = ((float) newHeight) / height;
    // CREATE A MATRIX FOR THE MANIPULATION
    Matrix matrix = new Matrix();
    // RESIZE THE BIT MAP
    matrix.postScale(scaleWidth, scaleHeight);
// "RECREATE" THE NEW BITMAP
Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
return resizedBitmap;