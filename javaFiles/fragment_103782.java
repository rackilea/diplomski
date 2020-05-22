public RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    redisTemplate.setExposeConnection(true);
    redisTemplate.setKeySerializer(new StringRedisSerializer());

    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
    redisTemplate.afterPropertiesSet();
    redisTemplate.boundSetOps("myKey").add("user");
    return redisTemplate;
}