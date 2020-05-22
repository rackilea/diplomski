@SpringBootApplication
public class MyApp{

public static void main(String[] args){
    SpringApplication application = new SpringApplication(MyApp.class);

    Properties properties = new Properties();
    properties.put("spring.jersey.type", "filter");
    application.setDefaultProperties(properties);

    application.run(args);
  }
}