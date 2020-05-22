@Configuration
@EnableFeignClients(
  clients = {
    MyFirstClient.class, // will NOT have CustomInterceptor registered
    MySecondClient.class // will have CustomInterceptor registered
  })
public class FeignConfig {

  @Autowired
  private BeanDependentOnMyFirstClient beanDependentOnMyFirstClient;

  @Bean
  public RequestInterceptor myCustomInterceptor() {
    return new CustomInterceptor();
  }
}