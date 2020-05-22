@Configuration
static class AuthenticationConfiguration implements AuthenticationManagerConfigurer {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //we need to put here ldap authentication, e.g.:
        auth.ldapAuthentication().userDnPatterns("CN={0},OU=Users").contextSource().url("ldap://my.ldap.server:port").managerDn("adminDn").managerPassword("adminPassword");

    }
}