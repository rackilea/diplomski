package my.test;
import org.springframework.context.annotation.*;

@ImportResource({"my/test/applicationContext.xml"})
public class AppConfig {

   @Bean(name="helloBean")
   public Object hello() {
      return new HelloWorld();
   }
}