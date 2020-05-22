@Override
protected void configure(AuthenticationManagerBuilder auth) {
    auth
        .authenticationProvider(new CustomAuthenticationProvider())
        .authenticationProvider(
            new MyLdapAuthenticationProvider(ldapAuthenticationProvider()));
}