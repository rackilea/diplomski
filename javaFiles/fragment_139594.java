import com.gateway.utils.LdapFailAwareRedisObjectSerializer;

@Configuration
public class RedisConfiguration {

  @Primary
  @Bean
  public RedisTemplate<String,ExpiringSession> redisTemplate(RedisConnectionFactory connectionFactory) {
    RedisTemplate<String, ExpiringSession> template = new RedisTemplate<String, ExpiringSession>();

    template.setKeySerializer(new StringRedisSerializer());
    template.setHashKeySerializer(new StringRedisSerializer());
    template.setHashValueSerializer(new LdapFailAwareRedisObjectSerializer());

    template.setConnectionFactory(connectionFactory);
    return template;
  }
}