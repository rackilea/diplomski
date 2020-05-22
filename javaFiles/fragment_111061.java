@Configuration
public class MiscConfiguration {

   @Bean
   public MyClass myClass() {
      return new MyClass();//Will be created/managed by Spring, @Autowired will work
   }
}