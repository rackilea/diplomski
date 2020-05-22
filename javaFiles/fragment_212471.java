@Configuration
@EnableWebMvc
@EnableCaching
@ComponentScan("com.yonosoft.poc.cache")
public class ApplicationConfig extends CachingConfigurerSupport {
    @Bean
    @Override
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        GuavaCache todoCache = new GuavaCache("todo", CacheBuilder.newBuilder()
            .refreshAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(10)
            .build(new CacheLoader<Object, Object>() {
                @Override
                public Object load(Object key) throws Exception {
                    CacheKey cacheKey = (CacheKey)key;
                    return cacheKey.method.invoke(cacheKey.target, cacheKey.params);
                }
            }));

        simpleCacheManager.setCaches(Arrays.asList(todoCache));

        return simpleCacheManager;
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return new CacheKey(target, method, params);
            }
        };
    }

    private class CacheKey extends SimpleKey {
        private static final long serialVersionUID = -1013132832917334168L;
        private Object target;
        private Method method;
        private Object[] params;

        private CacheKey(Object target, Method method, Object... params) {
            super(params);
            this.target = target;
            this.method = method;
            this.params = params;
        }
    }
}