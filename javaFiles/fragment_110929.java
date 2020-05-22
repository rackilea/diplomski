@Bean
LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    DataSource ds = getDataSource();
    sessionFactoryBean.setDataSource(ds);
    sessionFactoryBean.setPackagesToScan(Properties.hibernate.packages);
    sessionFactoryBean.setHibernateProperties(databaseSettings.getHibernateProperties());

    // conduct an early connection attempt which auto-closes the opened connection 
    try (Connection con = ds.getConnection(username, password)) {  
        // if you reach this line, connections to the DB can be established.
        return sessionFactoryBean;
    } catch (Exception ex {
        // handle exceptions with one or more of these steps
        // 1. log the problem to somewhere, console...
        // 2. re-try connection attempt?
        // 3. escalate by throwing a self-defined RuntimeException 
        // .. and shutdown the application in controlled manner? 
    }
}