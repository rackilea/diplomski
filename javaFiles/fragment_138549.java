@Configuration
public class AuthenticationManagerProvider {

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}