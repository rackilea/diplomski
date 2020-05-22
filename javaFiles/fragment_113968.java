@Bean
    @Primary
    public RedisCacheManager redisCacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration.usePrefix();


        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(lettuceConnectionFactory)
                .cacheDefaults(redisCacheConfiguration).build();
    }

    @Bean
    public LettuceClusterConnection getConnection(LettuceConnectionFactory lettuceConnectionFactory) {
        LettuceClusterConnection clusterConnection = (LettuceClusterConnection) lettuceConnectionFactory.getClusterConnection();
        return clusterConnection;
    }


    @Bean(name = "inMemoryCache")
    public CaffeineCacheManager inMemoryCache() {
        CaffeineCacheManager cacheManager =  new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    Caffeine< Object, Object > caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(3000)
                .maximumSize(40000)
                .expireAfterAccess(30, TimeUnit.MINUTES);
    }