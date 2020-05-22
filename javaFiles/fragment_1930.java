@Configuration
public class AppConfig {
  @Bean
  public Foo obj(){
      return new Foo();
  }
  @Bean
  public CustomerRepository repo(){
      return new CustomerRepository();
  }
}