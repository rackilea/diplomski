@Override
public void configure(HttpSecurity http) throws Exception {
    http
        .requestMatcher(new OrRequestMatcher(
            new AntPathRequestMatcher("/path/to/oauth/endpoints/*"),
            new AntPathRequestMatcher("/oauth/protected/resource")
        ))
        .authorizeRequests().anyRequest().authenticated();
}