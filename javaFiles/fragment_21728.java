@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
private UserDetailsService userDetailsService;


@Override
protected void configure(HttpSecurity http) throws Exception {
    http
                .authorizeRequests()
                .antMatchers("/", "/shop/**").permitAll()
                .antMatchers("/discounts/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
            .and()
                .formLogin()
                .usernameParameter("alias")
                .passwordParameter("password")
                .loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/")
                .permitAll()
            .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/")
                .permitAll();
}


@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
}

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

}