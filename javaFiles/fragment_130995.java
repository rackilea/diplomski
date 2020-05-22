@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .csrf().disable()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/getpin")
            .usernameParameter("j_username")
            .passwordParameter("j_password")
            .loginProcessingUrl("/j_spring_security_check")
            .failureUrl("/login")
            .permitAll()
            .and()
        .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .and()
        .authorizeRequests()
            .antMatchers("/getpin").hasAuthority("get_pin")
            .antMatchers("/securemain/**").hasAuthority("full_access")
            .antMatchers("/j_spring_security_check").permitAll()
            .and()
        .userDetailsService(userDetailsService);
    }
}