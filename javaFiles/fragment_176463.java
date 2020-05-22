@Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/**");
    }