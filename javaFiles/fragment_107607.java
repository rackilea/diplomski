@EnableCaching
@Configuration
public class CacheConf {
    @Bean
    public CacheManager cacheManager() {
        EhcacheCachingProvider provider = (EhcacheCachingProvider) Caching.getCachingProvider();

        Map<String, CacheConfiguration<?, ?>> caches = new HashMap<>();
        caches.put("properties", getPropCache());
        caches.put("propertyTypes", getPropCache());

        DefaultConfiguration configuration = new DefaultConfiguration(caches, provider.getDefaultClassLoader());
        return new JCacheCacheManager(provider.getCacheManager(provider.getDefaultURI(), configuration));
    }

  private CacheConfiguration<?, ?> getPropCache() {
    // access to the heap() could be done directly cause this returns what is required!
    final ResourcePoolsBuilder res = ResourcePoolsBuilder.heap(1000);
    // Spring does not allow anything else than Objects...
    final CacheConfigurationBuilder<Object, Object> newCacheConfigurationBuilder = CacheConfigurationBuilder
        .newCacheConfigurationBuilder(Object.class, Object.class, res);
    return newCacheConfigurationBuilder.build();
  }
}