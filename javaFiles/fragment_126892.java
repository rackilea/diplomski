public class CustomEnvironmentLoaderListener extends EnvironmentLoaderListener {

    @Inject
    private JpaRealm jpaRealm;

    @Override
    protected WebEnvironment createEnvironment(ServletContext pServletContext) {
        WebEnvironment environment = super.createEnvironment(pServletContext);
        RealmSecurityManager rsm = (RealmSecurityManager) environment.getSecurityManager();
        PasswordService passwordService = new DefaultPasswordService();
        PasswordMatcher passwordMatcher = new PasswordMatcher();
        passwordMatcher.setPasswordService(passwordService);
        jpaRealm.setCredentialsMatcher(passwordMatcher);
        rsm.setRealm(jpaRealm);
        ((DefaultWebEnvironment) environment).setSecurityManager(rsm);
        return environment;
    }

}