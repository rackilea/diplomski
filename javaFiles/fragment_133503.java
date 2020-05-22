private ImageLoader.ImageCache mImageCache;    
private VolleySingleton(){
    mRequestQueue =  Volley.newRequestQueue(VolleyApplication.getAppContext());
    mImageLoader = new ImageLoader(this.mRequestQueue,  mImageCache = new ImageLoader.ImageCache() {
        private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
        public void flushLruCache(){ mCache.evictAll();};
        public void putBitmap(String url, Bitmap bitmap) {
            mCache.put(url, bitmap);
        }
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }


    });
}