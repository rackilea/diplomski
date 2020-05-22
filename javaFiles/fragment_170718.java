@EnableWebSecurity
@Configuration
public class CustomWebSecurityConfigurerAdapter extends
   WebSecurityConfigurerAdapter {
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) {
    auth
      .inMemoryAuthentication()
        .withUser("user")  // #1
          .password("password")
          .roles("USER")
          .and()
        .withUser("admin") // #2
          .password("password")
          .roles("ADMIN","USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeUrls()
        .antMatchers("/signup","/about").permitAll();
  }
}