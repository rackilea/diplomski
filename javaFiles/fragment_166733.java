@Component
@Configuration
public class RedisConfig {

    @Bean(name = "redisTemplateA")
    public RedisTemplate<String, Object> redisTemplateA(RedisClusterConfig redisClusterConfigA) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(createClusterFactoryA(redisClusterConfigA));
        return template;
    }

    @Primary
    @Bean(name = "singleFactoryA")
    public LettuceConnectionFactory createSingleFactoryA(RedisSingleConfig redisSingleConfigA){...}

    @Bean(name = "clusterFactoryA")
    public LettuceConnectionFactory createClusterFactoryA(RedisClusterConfig redisClusterConfigA){...}

    // other combinations as needed
}