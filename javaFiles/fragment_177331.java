// SecurityConfiguration.java
@Bean
public UserDetailsContextMapper userDetailsContextMapper() {
    return new LdapUserDetailsMapper() {
        @Override
        public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
            UserDetails details = super.mapUserFromContext(ctx, username, authorities);
            return new CustomLdapUserDetails((LdapUserDetails) details, ctx);
        }
    };
}

@Inject
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    LdapContextSource contextSource = new LdapContextSource();
    contextSource.setUrl(applicationProperties.getLdap().getUrl());
    contextSource.setBase(applicationProperties.getLdap().getBase());
    contextSource.setUserDn(applicationProperties.getLdap().getUserDn());
    contextSource.setPassword(applicationProperties.getLdap().getPassword());
    contextSource.afterPropertiesSet(); //needed otherwise you will have a NullPointerException in spring

    auth.ldapAuthentication()
        .userDetailsContextMapper(userDetailsContextMapper())
        .userSearchBase(applicationProperties.getLdap().getSearchBase()) //don't add the base
        .userSearchFilter(applicationProperties.getLdap().getSearchFilter())
        .contextSource(contextSource)
    ;
}