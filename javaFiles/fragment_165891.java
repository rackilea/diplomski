@Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        http.authorizeRequests().anyRequest().anonymous()
        .antMatchers("/login**", "/*.js", "/*.css", "/*.svg" ).permitAll()
        // ... some other config
        .invalidateHttpSession(true)
        .permitAll()
        .and()
        .addFilterBefore(filter, CsrfFilter.class); // <- this was added
    }