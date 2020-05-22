@Configuration
@EnableWebSecurity
public class WebSecConf extends WebSecurityConfigurerAdapter {

@Autowired
PersistentTokenRepository persistenceTokenRepository;
@Autowired
UserDetailsService userDetailsService;
    ...

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .rememberMe()
                .tokenRepository(persistenceTokenRepository)
                .rememberMeCookieName("rememberme")
                .tokenValiditySeconds(60 * 60 * 24) 
                .alwaysRemember(true)
                .useSecureCookie(true)
                .and()
            ....
       ...
    }

@Bean
public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
    PersistentTokenBasedRememberMeServices persistenceTokenBasedservice = new PersistentTokenBasedRememberMeServices("rememberme", userDetailsService, persistenceTokenRepository);
    persistenceTokenBasedservice.setAlwaysRemember(true);
    return persistenceTokenBasedservice;
  }
}