@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) {
        // ...

        http.addFilterAfter(new XGroupFilter(), OAuth2AuthenticationProcessingFilter.class);
    }
}