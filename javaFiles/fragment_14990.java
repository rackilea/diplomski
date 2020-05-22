/*
 * (non-Javadoc)
 * 
 * @see org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter#configure(org.springframework.security.
 * config.annotation.web.builders.HttpSecurity)
 */
@Override
protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/loginProcessor").permitAll()
            .antMatchers("/login").permitAll().antMatchers("/registration").permitAll()
            .antMatchers("/accountverification/**").permitAll().antMatchers("/secure/**").hasAuthority("MEMBER")
            .anyRequest().authenticated().and().formLogin().loginPage("/login").failureUrl("/login?error=true")
            .defaultSuccessUrl("/secure/notes").usernameParameter("email").passwordParameter("password").and()
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
            .exceptionHandling().accessDeniedPage("/access-denied");
}