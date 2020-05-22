@Configuration
 public class Config {
     @Bean
     public C myFirstC(A a, B b) {
         return new C(Arrays.asList(a, b));
     }


     @Bean
     public C mySecondC(D d, E e) {
         return new C(Arrays.asList(d, e));
     }
 }