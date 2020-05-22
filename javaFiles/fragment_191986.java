@Configuration
public class AuthenticationManagerConfiguration extends
        GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) {
        auth.inMemoryAuthentication() // ... etc. <-------
    }