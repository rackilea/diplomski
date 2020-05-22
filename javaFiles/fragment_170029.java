@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/**").hasRole("USER")
        .antMatchers("/admin/**").hasRole("ADMIN"):
}