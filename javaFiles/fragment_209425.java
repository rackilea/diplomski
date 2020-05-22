@SpringBootApplication
public class HelloWorldApp {

  // ...    

  @Bean
  public HelloWorldClient helloWorldClient() {
     return new HelloWorldClient();
  }

}