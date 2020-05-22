public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http, final List<HttpSecurityConfig> httpConfigurations) {
    http.securityMatcher(ServerWebExchangeMatchers.pathMatchers("/api/**"))
            .authenticationManager(this.authenticationManager);

    // This line replaces the individual configurations in your original question
    httpConfigurations.forEach(config -> config.configuration().accept(http));

    http.authorizeExchange().pathMatchers(HttpMethod.POST, "/api/login", "/api/logout", "/api/forgotPassword", "/api/confirmForgotPassword").permitAll();

    http.csrf()
            .disable()
            .formLogin()
            .authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED))
            .requiresAuthenticationMatcher(
                    ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, "/api/login"))
            .authenticationFailureHandler(CustomSpringSecurity::onAuthenticationFailure)
            .authenticationSuccessHandler(CustomSpringSecurity::onAuthenticationSuccess)
            .and()
            .logout()
            .logoutUrl("/api/logout")
            .logoutSuccessHandler(new CustomLogoutSuccessHandler(HttpStatus.OK));

    final SecurityWebFilterChain build = http.build();

    build
            .getWebFilters()
            .collectList()
            .subscribe(
                    webFilters -> {
                        for (WebFilter filter : webFilters) {
                            if (filter instanceof AuthenticationWebFilter) {
                                AuthenticationWebFilter awf = (AuthenticationWebFilter) filter;
                                awf.setServerAuthenticationConverter(CustomSpringSecurity::convert);
                            }
                        }
                    });

    return build;
}