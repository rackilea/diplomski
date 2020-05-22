@Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers(HttpMethod.OPTIONS)
                .antMatchers(HttpMethod.TRACE)
                .antMatchers(HttpMethod.PATCH)
                .antMatchers(HttpMethod.PUT)
                .antMatchers(HttpMethod.POST)
                .antMatchers(HttpMethod.GET);
    }