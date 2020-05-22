@Configuration
public class ConfigA {
    public @Bean User getUser () {
        // Here do whatever it takes to create/lookup the user
        return new User();
    }
}