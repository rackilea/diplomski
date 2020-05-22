@Bean
public RememberMeServices rememberMeServices(String internalSecretKey) {
    LdapContextSource ldapContext = getLdapContext();

    String searchBase = "OU=Users,DC=test,DC=company,DC=com";
    String searchFilter = "(&(objectClass=user)(sAMAccountName={0}))";
    FilterBasedLdapUserSearch search = new FilterBasedLdapUserSearch(searchBase, searchFilter, ldapContext);
    search.setSearchSubtree(true);

    LdapUserDetailsService rememberMeUserDetailsService = new LdapUserDetailsService(search);
    rememberMeUserDetailsService.setUserDetailsMapper(new CustomUserDetailsServiceImpl());

    InMemoryTokenRepositoryImpl rememberMeTokenRepository = new InMemoryTokenRepositoryImpl();

    PersistentTokenBasedRememberMeServices services = new PersistentTokenBasedRememberMeServices(internalSecretKey, rememberMeUserDetailsService, rememberMeTokenRepository);
    services.setAlwaysRemember(true);
    return services;
}

@Bean
public LdapContextSource getLdapContext() {
    LdapContextSource source = new LdapContextSource();
    source.setUserDn("user@"+DOMAIN);
    source.setPassword("password");
    source.setUrl(URL);
    return source;
}