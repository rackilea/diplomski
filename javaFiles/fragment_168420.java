@Bean
public CacheManager cacheManager() {
    final Map<String, CacheBuilder> cache = new HashMap<>();
    for (final String appCache : "127.0.0.1,127.0.0.2,127.0.0.3".split(",")) {
     cache.put(appCache, CacheBuilder.newInstance(CouchbaseCluster.create().openBucket(
                    "default", "")));
    }
    return new CouchbaseCustomCacheManager(cache);
}