@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        JndiTemplate jndiTemplate = new JndiTemplate();
        try {
            EmbeddedCacheManager embededCacheManager = (EmbeddedCacheManager) jndiTemplate.lookup("java:jboss/infinispan/container/my-cache");
            SpringEmbeddedCacheManager cacheManager = new SpringEmbeddedCacheManager(embededCacheManager);
            return cacheManager;
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
}