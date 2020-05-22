protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .successHandler(new MyAuthenticationSuccessHandler())
                .and()
            .httpBasic().and()
            .authorizeRequests()
                .antMatchers("/registration-form").permitAll()
                .antMatchers("/confirm-email**").permitAll()
                .antMatchers("/submit-phone").permitAll()
                .antMatchers("/check-pin").permitAll()
                .antMatchers("/send-pin").permitAll()
                .antMatchers("/index.html", "/", "/login", "/message", "/home", "/public*", "/confirm*", "/register*").permitAll()
                .anyRequest().authenticated()
                .and()
            .csrf()
                .csrfTokenRepository(csrfTokenRepository())
                .and()
            .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
    }