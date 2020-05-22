private static void createCacheForOkHTTP() {
    Cache cache = null;
    cache = new Cache(getDirectory(), 1024 * 1024 * 10);
    okHttpClient.setCache(cache);
}

// returns the file to store cached details
private File getDirectory() {
    return new File(“location”);
}