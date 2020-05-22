private CacheFactory initCacheFactory() {
     CacheFactory cacheFactory =
       (CacheFactory)Discover.locate(
         CacheFactory.class.getName(),
         LRUCacheFactory.class.getName(),
         abdera);
     return cacheFactory;
   }