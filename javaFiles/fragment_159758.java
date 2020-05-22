@Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){

        LoginPageGeneratingWebFilter loginpage= new LoginPageGeneratingWebFilter();
        loginpage.setFormLoginEnabled(true);
        return httpSecurity
                .addFilterAt(loginpage, SecurityWebFiltersOrder.LOGIN_PAGE_GENERATING)
                .authorizeExchange()
                    .pathMatchers("/home").authenticated()
                        .and().formLogin()                      
                            .loginPage("/login")                         
                        .and()
                        .logout()
                        .logoutUrl("/logout").requiresLogout(ServerWebExchangeMatchers.pathMatchers(HttpMethod.GET, "/logout"))
                        .and()

                .build();

    }