public static Bitmap decodeBitmap(Uri bitmapUri, ContentResolver resolver, int width, int height) throws IOException{
    InputStream is = resolver.openInputStream(bitmapUri);
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;      
    BitmapFactory.decodeStream(is,null,options);
    is.close();

    int ratio = Math.min(options.outWidth/width, options.outHeight/height);
    int sampleSize = Integer.highestOneBit((int)Math.floor(ratio));
    if(sampleSize == 0){
        sampleSize = 1;
    }       
    Log.d(RSBLBitmapFactory.class, "Sample Size: " + sampleSize);

    options = new BitmapFactory.Options();
    options.inSampleSize = sampleSize;

    is = resolver.openInputStream(bitmapUri);
    Bitmap b = BitmapFactory.decodeStream(is,null,options);
    is.close();
    return b;
}

<ImageView android:scaleType="fitXY"></ImageView>