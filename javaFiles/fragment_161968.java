@SpringBootApplication
public class MyApp
 public static void main(String[] args) {
   SpringApplication app = new SpringApplication(MyApp.class);
   app.setAdditionalProfiles("jersey"); 
   app.run(args);
 }
}