@Configuration
public class SpotifySecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/home", "/login**","/callback/", "/webjars/**", "/error**", "/oauth2/authorization/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .oauth2Login();
  }
}