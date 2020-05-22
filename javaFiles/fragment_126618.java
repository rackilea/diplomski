@EnableCaching
@Configuration
public class CacheConf{
    @Bean(name = "springCM")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("entities");
    }
}