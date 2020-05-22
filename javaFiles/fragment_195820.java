@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Inject
        private AuthenticationProvider authenticationProvider;

        @Inject
        protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/**")
                .authorizeRequests().anyRequest()
                .fullyAuthenticated().and().httpBasic();
        }
}