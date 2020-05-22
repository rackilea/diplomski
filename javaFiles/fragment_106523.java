@Configuration
@RequiredArgsConstructor
public class CamelConfig {

  private final CachingConnectionFactory rabbitConnectionFactory;

  @Bean
  com.rabbitmq.client.ConnectionFactory rabbitSourceConnectionFactory() {
    return rabbitConnectionFactory.getRabbitConnectionFactory();
  }
}