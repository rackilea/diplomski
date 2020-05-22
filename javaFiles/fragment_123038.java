public class ShiroAuthModule extends ShiroModule {

  @Override
  public void configure() {
    super.configure();
    // Bind your data source however you need to - I use JNDI 
    // but it would be easy to switch to a properties file.
    bind(Context.class).to(InitialContext.class);
    bind(DataSource.class).toProvider(JndiIntegration.fromJndi(DataSource.class, "java:/comp/env/jdbc/security"));
  }

  @Provides
  @Singleton
  JdbcRealm loadJdbcRealm(Ini ini, DataSource ds, 
      @Named("shiro.authenticationQuery") String authenticationQuery,
      @Named("shiro.userRolesQuery") String roleQuery,
      @Named("shiro.permissionsQuery") String permissionQuery) {
    JdbcRealm realm = new JdbcRealm();
    realm.setAuthenticationQuery(authenticationQuery);
    realm.setUserRolesQuery(roleQuery);
    realm.setPermissionsQuery(permissionQuery);
    realm.setPermissionsLookupEnabled(true);
    realm.setDataSource(ds);
    return realm;
  }

  @Override
  protected void configureShiro() {
    // shiro.properties should be on your classpath and 
    // contain the named properties in loadJdbcRealm
    Properties properties = Module.loadProperties(this, "shiro.properties");
    Names.bindProperties(binder(), properties);
    try {
      bindRealm().to(JdbcRealm.class);
    } catch (SecurityException e) {
      addError(e);
    }
  }

}