http.authorizeRequests()
.antMatchers("/admin/**").hasRole("ADMIN")                                      
.anyRequest().fullyAuthenticated()
.and()
.formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
.and()
.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");