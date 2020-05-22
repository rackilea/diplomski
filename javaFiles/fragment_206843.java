@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Bean
public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers(HttpMethod.POST, "/services/**")
      .authenticated()
      .addFilterBefore(tokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
  }

@Bean
public TokenFilter tokenFilterBean() {
    return new TokenFilter();
  }    

}