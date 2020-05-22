@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

    // overides deafult password, here you can add additional users
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("*******").password("******").roles("USER")
                .and()
                .withUser("*****").password("*****").roles("USER", "ADMIN");
        System.out.println("global configurer finished");
    }
}