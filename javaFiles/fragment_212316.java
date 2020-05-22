@Override
protected void configure(HttpSecurity http) throws Exception {

    http.
        authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/signin").permitAll()

            .antMatchers("/confirm").permitAll()
            .antMatchers("/index").permitAll()
            .antMatchers("/adminpage").permitAll()
            .antMatchers("/register").permitAll()
            .antMatchers("/login").permitAll()

   .antMatchers("/library/**","/admin").hasAuthority("ADMIN").anyRequest()
            .authenticated().and().csrf().disable().formLogin()
            .loginPage("/login").failureUrl("/login?error=true")
            .defaultSuccessUrl("/index", true)              
            .usernameParameter("email")
            .passwordParameter("password")
            .and().logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/").and().exceptionHandling()
            .accessDeniedPage("/access-denied");

}