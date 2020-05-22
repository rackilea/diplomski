@Configuration
@ConfigurationProperties(prefix = "myconf")
public class MyConfigs {

   // ... rest of my configs

   private OptionalServiceConfigs service;

   public static class OptionalServiceConfigs {

       private String mode = "local";

       private long timeout = 30000L;

       // ... rest of getter and setters
   }

   public MyConfigs() {
      service = new OptionalServiceConfigs();
   }

   // ... rest of getter and setters
}