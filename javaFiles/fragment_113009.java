public class RedisConfig {

@Value("${redis.hostname}")
private String redisHostName;

@Value("${redis.port}")
private int redisPort;

@Bean
protected JedisConnectionFactory jedisConnectionFactory() {
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHostName, redisPort);
    JedisConnectionFactory factory = new JedisConnectionFactory(configuration);
    return factory;
}

@Bean
public RedisTemplate<String,Integer> redisTemplate() {
    final RedisTemplate<String, Integer> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    return redisTemplate;
}