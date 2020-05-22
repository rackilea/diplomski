OkHttpClient client = new OkHttpClient();
client.networkInterceptors().add(REWRITE_CACHE_CONTROL_INTERCEPTOR);

//setup cache
File httpCacheDirectory = new File(context.getCacheDir(), "responses");
int cacheSize = 10 * 1024 * 1024; // 10 MiB
Cache cache = new Cache(httpCacheDirectory, cacheSize);

//add cache to the client
client.setCache(cache);