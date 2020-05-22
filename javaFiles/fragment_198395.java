@Bean
public RedisTemplate<String, MyDto> redisTemplateMyDto() {
    final RedisTemplate<String, MyDto> template = new RedisTemplate<String, MyDto>();
    template.setConnectionFactory(redisConnectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    return template;
}