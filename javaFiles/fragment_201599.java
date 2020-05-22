@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(customAuthenticationProvider());
}

@Bean
AuthenticationProvider customAuthenticationProvider() {
    CustomAuthenticationProvider impl = new CustomAuthenticationProvider();
    impl.setUserDetailsService(customUserDetailsService());
    /* other properties etc */
    return impl ;
}

@Bean   
UserDetailsService customUserDetailsService() {
    /* custom UserDetailsService code here */
}