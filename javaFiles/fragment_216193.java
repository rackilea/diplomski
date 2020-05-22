@Override
protected SessionFactory buildSessionFactory() throws Exception {
    Configuration config = new Configuration();
    config.configure(
             new File( BaseConfig.CONFIG_BASE 
                        + File.separator 
                        + "hibernate.cfg.xml" ) 
    );
    SessionFactory sessionFactory = config.buildSessionFactory(); 
    return sessionFactory;
}