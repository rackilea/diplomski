@Autowired
@Bean
public LocalSessionFactoryBean getSessionFactoryBean(DataSource dataSource) {
    LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(this.getDataSource());
  //sessionFactory.setHibernateProperties(this.hibernateProperties());

    return localSessionFactoryBean;
 }