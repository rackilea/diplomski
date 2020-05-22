@Configuration
public class CacheConfig {

  @Bean
  public CacheManager cacheManager() {
    CaffeineCacheManager cacheManager = new CaffeineCacheManager("cache1",
        "cache2", "cache3");
    cacheManager.setCacheSpecification("recordStats");
    return cacheManager;
  }
}