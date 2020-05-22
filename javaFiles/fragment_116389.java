@Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
         sessionFactory.setPackagesToScan(new String[] { "my.package.model" });// You need to provide to adapt : my.package.model
        sessionFactory.setHibernateProperties(hibernateProperties());
       return sessionFactory;
}