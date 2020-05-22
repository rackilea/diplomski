@Configuration
public class CacheService extends CachingConfigurerSupport {
    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager() {
            @Override
            protected Cache createConcurrentMapCache(final String name) {
                return new ConcurrentMapCache(name,
                        CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.MINUTES).maximumSize(100).build().asMap(), false);
            }
        };
        return cacheManager;
    }
    @Bean
    @Primary
    public CacheManager guavaCacheManager() {
        return new GuavaCacheManager();
    }
}