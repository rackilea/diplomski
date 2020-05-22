@Autowire private CacheManager cacheManager;

public void setItem(UUID id, Thing thing) {
  Cache c = cacheManager.getCache("cacheName");
  if (c != null) {
    c.put(id, thing);   
  }
  //Do more
}