@Configuration
@ComponentScan("com.acme.app.services")
 public class AppConfig {
     @Bean
     public MyBean myBean() {
         // instantiate, configure and return bean ...
     }
 }