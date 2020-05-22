@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
              .withUser("lovelyOne").password("hothusband").roles("BRIDE");
    }