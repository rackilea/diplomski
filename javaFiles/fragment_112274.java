/**
 * @author audrius Bitmap cache
 */
private static class BitmapCache {
    //private static final String TAG = "BitmapCache";
    private final int mCacheSize;
    private final String mBitmapLocation;
    private LinkedHashMap<String, Bitmap> mBitmapCache;

    /**
     * Constructor
     * 
     * @param cacheSize
     *            Cache size in element count (e.g. 8 = at most 8 Bitmaps in
     *            cache)
     * @param bitmapLocation
     *            Physical root path to bitmap location
     */
    public BitmapCache(int cacheSize, String bitmapLocation) {
        mCacheSize = cacheSize;
        mBitmapLocation = bitmapLocation;

        mBitmapCache = new LinkedHashMap<String, Bitmap>(mCacheSize + 1) {
            private static final long serialVersionUID = -4156123801558395154L;

            @Override
            protected boolean removeEldestEntry(
                    java.util.Map.Entry<String, Bitmap> eldest) {
                return size() > mCacheSize;
            };

            @Override
            public Bitmap remove(Object key) {
                Bitmap bmp = super.get(key);
                // make sure to release resources as soon as possible
                bmp.recycle();
                return super.remove(key);
            }
        };
    }

    /**
     * Returns Bitmap (either from cache or physical location)
     * 
     * @param bitmapFilename
     * @return
     */
    public Bitmap getBitmap(String bitmapFilename) {
        Bitmap ret = mBitmapCache.get(bitmapFilename);
        //Log.v(TAG, "getBitmap : " + bitmapFilename);
        if (ret == null) {
            //Log.v(TAG, "Bitmap not cached, reading location : " + mBitmapLocation);
            ret = BitmapFactory.decodeFile(new File(mBitmapLocation, bitmapFilename).getAbsolutePath());
            mBitmapCache.put(bitmapFilename, ret);
        }

        return ret;
    }

    /**
     * Clears bitmap cache
     */
    public void clear() {
        if (mBitmapCache != null) {
            for (Bitmap bitmap : mBitmapCache.values()) {
                if (bitmap != null) bitmap.recycle();
            }

            mBitmapCache.clear();
        }
    }
}