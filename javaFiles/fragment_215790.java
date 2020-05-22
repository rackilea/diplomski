@Bean
public RedisTemplate<String, Object> redisTemplate() {

    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setDefaultSerializer(new StringRedisSerializer()); // set here
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
}