import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {

 public Application(){
 packages("com.package.of.your.resources").
 register(JacksonFeature.class);
 }
}