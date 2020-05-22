@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

@Bean
  public MyLogger myAspect() {
    return new MyLogger();
}

@Bean
  public MyBean myBean() {
    System.out.println("MyBean is called");
    return new MyBean();
}

}