@Path("stats")
@Produces("text/plain")
public class StatsResource {
  @Inject private CacheManager cacheManager;

  @GET
  public String stats() {
    StringBuffer sb = StringBuffer();

    /* get stats for all known caches */
    for (String name : cacheManager.getCacheNames()) {
      Cache cache = cacheManager.getCache(name);
      Statistics stats = cache.getStatistics();

      sb.append(String.format("%s: %s objects, %s hits, %s misses\n",
        name,
        stats.getObjectCount(),
        stats.getCacheHits(),
        stats.getCacheMisses()
      ));
    }
    return sb.toString();
  }
}