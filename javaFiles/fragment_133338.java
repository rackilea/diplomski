@Autowired
private LocalSessionFactoryBean localSessionFactoryBean;

@Bean
public DataSource getDataSource() {
  //return the data source here
}

@Bean(name = "hibernateConfig")
public org.hibernate.cfg.Configuration getConfig() {
    return localSessionFactoryBean.getConfiguration();
}