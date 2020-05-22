public class URLConnectionImageDownloader extends ImageDownloader {
    @Override
    public InputStream getStreamFromNetwork(URI imageUri) throws IOException {
        URLConnection conn = imageUri.toURL().openConnection();
        // check etag/last-modification-date/... params
        // if image was changed then we should delete cached image from memory cache and disc cache

        // Delete image from caches
        String uri = imageUri.toString();
        File imageFile = ImageLoader.getDiscCache().get(uri)
        if (imageFile.exists()) {
            imageFile.delete();
        }
        MemoryCacheAware<String, Bitmap memoryCache = ImageLoader.getMemoryCache();
        for (String cacheKey : memoryCache.keys()) {
            if (cacheKey.contains(uri) {
                memoryCache.remove(cacheKey);
            }
        }


        return new FlushedInputStream(new BufferedInputStream(conn.getInputStream()));
    }
}