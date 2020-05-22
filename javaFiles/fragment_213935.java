@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
@Qualifier("userDetailsService")
UserDetailsService userDetailsService;

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
}

@Override
protected void configure(HttpSecurity http) throws Exception {

    //authorization logic here ...
}

    @Bean
    public PasswordEncoder passwordEncoder(){
        // return preferred PasswordEncoder ...//
    }


}