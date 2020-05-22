http
  .csrf().disable().cors().disable()
  .formLogin().failureUrl("/login?error").defaultSuccessUrl("/")
  .loginPage("/login").permitAll()
  .and()
  .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
  .logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
  .and()
  .rememberMe();
}