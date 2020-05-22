@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache("a", createConfiguration(100, Duration.ofHours(24)));
        };
    }

    private javax.cache.configuration.Configuration<Object, Object> createConfiguration(long size, Duration tti) {
        return Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(size))
                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(tti))
                .build());
    }
}