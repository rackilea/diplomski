class SecurityModule extends ShiroWebModule {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  SecurityModule(ServletContext sc) {
    super(sc);
  }

  @Override
  protected void configureShiroWeb() {

    bindRealm().to(IniRealm.class);
    logger.info("SecurityModule.configureShiroWeb() method called");
  }

  @Provides
  @Singleton
  IniRealm loadIniRealm(Ini ini) {

    IniRealm realm = new IniRealm(ini);
    return realm;
  }

  @Provides
  @Singleton
  Ini loadShiroIni() {

    logger.info("SecurityModule.loadShiroIni() method called");
    return Ini.fromResourcePath("classpath:shiro.ini");
  }

}