@Bean
public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http,
                                                        ReactiveAuthenticationManager authManager) {
    return http
            .csrf().disable()
            .authorizeExchange()
            .pathMatchers("/api/**").authenticated()
            .pathMatchers("/**", "/login", "/logout").permitAll()
            .and().exceptionHandling().authenticationEntryPoint(restAuthEntryPoint)
            .and().addFilterAt(authenticationWebFilter(authManager), SecurityWebFiltersOrder.AUTHENTICATION)
            .logout()
            .and().build();
}