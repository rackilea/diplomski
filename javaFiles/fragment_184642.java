@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {


    @Configuration
    protected static class AuthenticationSecurity extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        private AuthenticationProvider authenticationProvider;

        public AuthenticationSecurity() {
            super();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
             auth.inMemoryAuthentication().withUser("admin").password("secret").roles("ADMIN");
        }
    }

    @Configuration
    @Order(Ordered.HIGHEST_PRECEDENCE + 2)
    public static class ManagementSecurityConfig extends WebSecurityConfigurerAdapter {


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .requestMatchers()
                    .antMatchers("/info/**")
                    .and()
                    .authorizeRequests()
                    .anyRequest().hasRole("ADMIN")
                    .and()
                    .httpBasic();
        }
    }

    @Configuration
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        protected void configure(HttpSecurity http) throws Exception {
            // API security configuration
        }

    }
}