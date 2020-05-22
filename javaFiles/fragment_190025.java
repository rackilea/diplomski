@Override
protected void configure(HttpSecurity http) throws Exception
    {
        http
                .antMatcher("/admin/**").authorizeRequests().anyRequest().authenticated().anyRequest().hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/adminLogin")
                .loginProcessingUrl("/admin/postLogin")
                .defaultSuccessUrl("/admin/home")
                .failureUrl("/adminLogin?error")
                .and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/home")
                .and()
                .csrf().disable();

    }