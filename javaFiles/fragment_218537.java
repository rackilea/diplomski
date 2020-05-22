@Configuration
class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AccessDeniedHandler accessDeniedHandler;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers(HttpMethod.GET, "/", "/orders").permitAll()
      .antMatchers(HttpMethod.POST, "/order/**").hasAnyRole("ADMIN")
      .antMatchers(HttpMethod.DELETE, "/order/**").hasAnyRole("ADMIN")
      .and()
      .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
    .and()  //added
    .httpBasic();  //added

  }

  // create two users, admin and user
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication()
      .withUser("user").password("password").roles("USER")
      .and()
      .withUser("admin").password("password").roles("ADMIN");
  }
}