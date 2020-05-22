@Configuration
public class ApiConfig {
    @Bean
    public Filter httpsEnforcerFilter(){
        return new HttpsEnforcer();
    }
}