public static Bitmap decodeFile(String pathName, Options opts) {
    Bitmap bm = null;
    InputStream stream = null;
    try {
        stream = new FileInputStream(pathName);
        bm = decodeStream(stream, null, opts);
    } catch (Exception e) {
        /*  do nothing.
            If the exception happened on open, bm will be null.
        */
        Log.e("BitmapFactory", "Unable to decode stream: " + e);
    } finally {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                // do nothing here
            }
        }
    }
    return bm;
}