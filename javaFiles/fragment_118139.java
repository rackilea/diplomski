final int maxSize = 960;
int outWidth;
int outHeight;
int inWidth = myBitmap.getWidth();
int inHeight = myBitmap.getHeight();
if(inWidth > inHeight){
    outWidth = maxSize;
    outHeight = (inHeight * maxSize) / inWidth; 
} else {
    outHeight = maxSize;
    outWidth = (inWidth * maxSize) / inHeight; 
}

Bitmap resizedBitmap = Bitmap.createScaledBitmap(myBitmap, outWidth, outHeight, false);