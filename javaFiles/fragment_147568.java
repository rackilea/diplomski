@Bean
public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory,
                                      ResourceLoader resourceLoader) {
    RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
            .builder(redisConnectionFactory)
            .cacheDefaults(determineConfiguration(resourceLoader.getClassLoader()));
    List<String> cacheNames = this.cacheProperties.getCacheNames();
    if (!cacheNames.isEmpty()) {
        builder.initialCacheNames(new LinkedHashSet<>(cacheNames));
    }
    return builder.build();
}

private org.springframework.data.redis.cache.RedisCacheConfiguration determineConfiguration(
        ClassLoader classLoader) {
    if (this.redisCacheConfiguration != null) {
        return this.redisCacheConfiguration;
    }
    CacheProperties.Redis redisProperties = this.cacheProperties.getRedis();
    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();

    ObjectMapper mapper = new Jackson2ObjectMapperBuilder()
            .modulesToInstall( new SimpleModule().addSerializer( new NullValueSerializer(null)) )
            .failOnEmptyBeans( false )
            .build();
    mapper.enableDefaultTyping( ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

    GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer( mapper );

    //get the mapper b/c they registered some internal modules
    config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));;

    if (redisProperties.getTimeToLive() != null) {
        config = config.entryTtl(redisProperties.getTimeToLive());
    }
    if (redisProperties.getKeyPrefix() != null) {
        config = config.prefixKeysWith(redisProperties.getKeyPrefix());
        config = config.computePrefixWith(cacheName -> redisProperties.getKeyPrefix() + cacheName + "::");
    }
    if (!redisProperties.isCacheNullValues()) {
        config = config.disableCachingNullValues();
    }
    if (!redisProperties.isUseKeyPrefix()) {
        config = config.disableKeyPrefix();
    }
    return config;
}