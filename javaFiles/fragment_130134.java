@Configuration
public class ApplicationConfiguration {
  @Bean
  HelloService helloService () {
    return new HelloServiceImpl();
  }
}