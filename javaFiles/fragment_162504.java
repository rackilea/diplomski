public class DDVideoEncoder  {

    private static final String TAG = DDVideoEncoder.class.getSimpleName();

    private SequenceEncoder encoder;


    public DDVideoEncoder(String filepath) throws IOException, OutOfMemoryError {
        File out = new File(filepath);
        encoder = new SequenceEncoder(out);

    }

    // returns false on out of memory error.
    public Boolean addFrame(String filePath, int newSize) throws IOException {

        // newSize indicates size of bitmap in percent
        Bitmap bi = getResizedBitmap(filePath, newSize);

        try { encoder.encodeImage(bi); }
        catch (OutOfMemoryError outOfMemoryError) { Log.d(TAG, "encodeImage:" + outOfMemoryError); return  false; }
        catch (NullPointerException nil) { Log.d(TAG, "encodeImage:"+nil); return  false; }
        return true;

    }

    public void finishEncoding(){
        try { encoder.finish(); }
        catch (IOException io) {
            Log.d("DDVideoEncoder", "IOException"); }
    }

    // newSize indicates size of bitmap in percent of original.
    //decodes image and scales it to reduce memory consumption
    private Bitmap getResizedBitmap(String filePath, int newSize) {

        //Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        //BitmapFactory.decodeStream(new FileInputStream(f),null,o);
        BitmapFactory.decodeFile(filePath, o);

        //The new size we want to scale to
        final int REQUIRED_SIZE=newSize*10;

        //Find the correct scale value. It should be the power of 2.
        int scale=1;
        while(o.outWidth/scale/2>=REQUIRED_SIZE && o.outHeight/scale/2>=REQUIRED_SIZE)
            scale*=2;

        //Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize=scale;
        //return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        return BitmapFactory.decodeFile(filePath, o2);
    }
}