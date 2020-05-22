private static final Object CACHE_KEY = new Object();

 private LoadingCache<Object, List<SomeType>> cache = 
      CacheBuilder.newBuilder()
        .expireAfterWrite(5, TimeUnit.MINUTES)
        .softValues()
        .build(valuesLoader());

 //...
 List<SomeType> values = cache.get(CACHE_KEY);