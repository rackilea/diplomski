@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/**")
            .hasAnyRole("ROLE1","ROLE2")
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/j_spring_security_check")
            .defaultSuccessUrl("/product/search", true)
            .permitAll()
            .and()
            .csrf()
            .disable()
            .logout()
            .logoutUrl("/j_spring_security_logout")
            .logoutSuccessUrl("/login");
    }