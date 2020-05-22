LruCache<String, Bitmap> memCache = new LruCache<>(size) {
    @Override
    protected int sizeOf(String key, Bitmap image) {
        return image.getByteCount()/1024;
    }
};