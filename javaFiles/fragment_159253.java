package stackoverflow.demo;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class FastFailWhenPropertyNotPresentApplication {

  static Boolean active;

  static {

    YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
    yaml.setResources(new ClassPathResource("application.yaml"));

    active = (Boolean) yaml.getObject().getOrDefault("myapp.active", false);

  }


    public static void main(String[] args) {
        if (!active) {
          System.err.println("your fail message");
        } else {
          SpringApplication.run(FastFailWhenPropertyNotPresentApplication.class, args);
        }
    }

}