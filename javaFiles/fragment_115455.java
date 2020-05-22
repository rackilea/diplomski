public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
     httpSecurity
      ...
      .formLogin()
  ...
  }
  ...
}