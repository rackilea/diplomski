@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        .antMatchers(HttpMethod.GET)
        .antMatchers("/favicon.ico", "/", "/index.html", "/registrar",
                "/autenticar", "/app/**");
    }