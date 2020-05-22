@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .inMemoryAuthentication()
        .passwordEncoder(passwordEncoder())
            .withUser("fooserviceuser").password("$2a$10$9DvfxB.Sj2B/QznFRw85FenDvhUGglWWgOR7mmal/jNImhdHQRJgi").roles("USER");
}

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/**").hasRole("USER")
    .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}

@Bean
public BCryptPasswordEncoder passwordEncoder(){
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    return encoder;
}
}