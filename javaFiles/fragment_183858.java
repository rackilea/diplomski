@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
}