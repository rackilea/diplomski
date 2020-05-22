private final Map<String, Bitmap> sHardBitmapCache = new LinkedHashMap<String, Bitmap>(HARD_CACHE_CAPACITY / 2,
        0.75f, true) {

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Bitmap> eldest) {
        if (size() > HARD_CACHE_CAPACITY) {
            sSoftBitmapCache.put(eldest.getKey(), new SoftReference<Bitmap>(eldest.getValue()));
            return true;
        } else
            return false;
    }
};