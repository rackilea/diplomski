@EnableTransactionManagement
@PropertySource("classpath:props.dbProps.properties")

@Bean
public DataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty(DRIVER));
    dataSource.setUrl(env.getRequiredProperty(URL));
    dataSource.setUsername(env.getRequiredProperty(USER_NAME));
    dataSource.setPassword(env.getRequiredProperty(PASSWORD));
    return dataSource;
}

@Bean
public LocalSessionFactoryBean getSessionFactory(){
    final LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
    lsfb.setDataSource(dataSource());
    lsfb.setPackagesToScan(env.getRequiredProperty(SCAN));
    lsfb.setHibernateProperties(hibProps());
    return lsfb;
}

@Bean
public PlatformTransactionManager transactionManager(){
    HibernateTransactionManager tx = new HibernateTransactionManager();
    tx.setSessionFactory(getSessionFactory().getObject());
    return tx;
}

private Properties hibProps(){
    Properties p = new Properties();
    p.put(DIALECT, env.getRequiredProperty(DIALECT));
    p.put(SHOW_SQL, env.getRequiredProperty(SHOW_SQL));
    p.put(HBM2DLL, env.getRequiredProperty(HBM2DLL));
    return p;
}