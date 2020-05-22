@Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http
                    .antMatcher("/customer/**").authorizeRequests().anyRequest().authenticated().anyRequest().hasRole("USER")
                    .and()
                    .formLogin()
                    .loginPage("/customerLogin")
                    .loginProcessingUrl("/customer/postLogin")
                    .defaultSuccessUrl("/customer/home")
                    .failureUrl("/customerLogin?error")
                    .and()
                    .logout().logoutUrl("/customer/logout").logoutSuccessUrl("/home")
                    .and()
                    .csrf().disable();

        }