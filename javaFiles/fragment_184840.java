// Same as before
.authorizeRequests()
    .antMatchers(HttpMethod.POST, "/user").permitAll()
    // Need authentication sur POST
    .antMatchers(HttpMethod.POST).authenticated()
    // Allow anonymous resource requests
    .anyRequest().permitAll()
.and
.csrf().disable();
// Same as before