@Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dataSource());
      sessionFactory.setPackagesToScan(new String[] { "package.to.your.entity.classes" });
      sessionFactory.setHibernateProperties(hibernateProperties());

      return sessionFactory;
   }

@Bean
public DataSource dataSource(){
   //define datasource
}

private  Properties hibernateProperties() {
   //hibernate props
}