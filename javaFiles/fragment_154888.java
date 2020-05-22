@Configuration
 public class SpringConfigB {

@Bean
 @Qualifier("compositeB")
     public Composite composite() {
         Composite c = new Composite();
         return c;             
     }
}