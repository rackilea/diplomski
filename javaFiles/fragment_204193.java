import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

@Bean
public CacheManager cacheManager() {
    return new ConcurrentMapCacheManager("skills", "othercachename");
}