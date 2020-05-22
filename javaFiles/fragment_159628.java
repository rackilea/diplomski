private Bitmap mainBitmap;
private BitmapFactory.Options mBitmapOptions;
private void initMainBitmap(Resources res,int resId){
    mBitmapOptions = new BitmapFactory.Options();
    mBitmapOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(res, resId,mBitmapOptions);

    mainBitmap = Bitmap.createBitmap(mBitmapOptions.outWidth,mBitmapOptions.outHeight,Bitmap.Config.ARGB_8888);
    mBitmapOptions.inJustDecodeBounds = false;
    mBitmapOptions.inBitmap = mainBitmap;//will cause the bitmap to be reused.
    mBitmapOptions.inSampleSize = 1;
}

private int currentFrameIndex = 0;
public boolean setToFrame(int frameIndex){
    if(pirates != null && frameIndex >= 0 && frameIndex< pirates.length){
        currentFrameIndex = frameIndex;
        mainBitmap = BitmapFactory.decodeResource(mResources, pirates[currentFrameIndex],mBitmapOptions);           
        return true;
    }
    else return false;
}