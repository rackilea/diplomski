@Configuration
 public class SpringConfigA {

@Bean
 @Qualifier("compositeA")
     public Composite composite() {
         Composite c = new Composite();
         return c;             
     }
}