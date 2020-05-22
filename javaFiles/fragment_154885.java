@Configuration
 public class SpringConfigA {

@Bean
     public Composite composite() {
         Composite c = new Composite();
         return c;             
     }
}