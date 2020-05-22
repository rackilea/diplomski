package stackoverflow.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class FastFailWhenPropertyNotPresentApplication {


  static class EnvironmentPrepared implements ApplicationListener<ApplicationEnvironmentPreparedEvent>{
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
      Boolean active = event.getEnvironment().getProperty("myapp.active",Boolean.class,Boolean.FALSE);
      if(!active) {
        throw new RuntimeException("APPLICATION FAILED TO START: ACTIVE SHOULD BE TRUE ");
      }
    }
  };


  public static void main(String[] args) throws Exception {
    SpringApplication springApplication = new SpringApplication(FastFailWhenPropertyNotPresentApplication.class);
    springApplication.addListeners(new FastFailWhenPropertyNotPresentApplication.EnvironmentPrepared());
    springApplication.run(args);
  }

}