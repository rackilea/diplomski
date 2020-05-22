public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

      http.
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        .and()
        .authorizeRequests()
        .antMatchers("/oauth/token", "/oauth/authorize**", "/login**", "/user/recover_password", "/user/register").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .and()
        .logout().logoutUrl("/oauth/logout")
        .and()
        .csrf().disable();
    }
}