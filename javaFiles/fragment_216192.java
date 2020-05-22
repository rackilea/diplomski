@Override
protected SessionFactory buildSessionFactory() throws Exception {
    Properties dbConfig = new Properties();
    dbConfig = baseConfig.getPropertiesFile("myPropertiesFile");

    Configuration config = new Configuration();
    Enumeration<Object> props = dbConfig.keys();

    while ( props.hasMoreElements() ){
        String key = (String)props.nextElement();
        config.setProperty( key , dbConfig.getProperty(key) ); 
    }
    config.addResource("hibernate.cfg.xml");

    SessionFactory sessionFactory = config.buildSessionFactory(); 
    return sessionFactory;
}