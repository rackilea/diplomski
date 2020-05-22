@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
..
..
@Override
  protected void configure(HttpSecurity http) throws Exception {
    http 
    .authorizeRequests().antMatchers("/oauth/authorize").authenticated()
    .and()
    .formLogin().permitAll()
    .and()
    .authorizeRequests().anyRequest().authenticated()
}
..
..
}