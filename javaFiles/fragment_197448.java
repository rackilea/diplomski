@Provides
@Singleton
CacheManager provideCacheManager() {
  CacheManager cacheManager = CacheManager.create();

  /* very basic cache configuration */
  CacheConfiguration config = new CacheConfiguration("mycache", 100)
    .timeToLiveSeconds(60)
    .timeToIdleSeconds(30)
    .statistics(true);

  Cache myCache = new Cache(config);
  cacheManager.addCacheIfAbsent(myCache);

  return cacheManager;
}