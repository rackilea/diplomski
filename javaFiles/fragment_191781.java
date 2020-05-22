protected void configure(HttpSecurity http) throws Exception {

 http
 .authorizeRequests()                                                                
.antMatchers("/resources/**", "/login").permitAll()                  
.antMatchers("/admin/**").hasRole("USER")                           
.and()

.formLogin()
    .loginPage("/login")
    .defaultSuccessUrl("/")
 //   .successHandler(successHandler) //----- to handle user role
    .failureUrl("/loginfailed")             
    .permitAll()
    .and()

.logout()
    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    .deleteCookies("JSESSIONID")
    .invalidateHttpSession( true )
    .and();