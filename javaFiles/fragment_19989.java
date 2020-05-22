@Configuration
public class Myconfig{

   @Bean 
   public MyBean myBean(){
      return new MyBean();
   }
}