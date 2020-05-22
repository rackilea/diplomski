@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
           register(JerseyController.class);
       }
   }