@Configuration
@EnableCaching
class CachingConfiguration extends CachingConfigurerSupport {

    final static String CACHE_RESOLVER_NAME = "simpleCacheResolver";

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean(CACHE_RESOLVER_NAME)
    public CacheResolver cacheResolver(CacheManager cacheManager) {
        return new RuntimeCacheResolver(cacheManager);
    }
}