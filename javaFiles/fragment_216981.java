@ConfigurationProperties("mine.application")
public class ApplicationProperties {

   private Map<String,Long> basicProjectId = new HashMap<>();

   public Map<String,Long> getBasicProjectId() { 
     return basicProjectId;
   }
}


@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class YourApp { .... }