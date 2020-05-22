LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
  factoryBean.setDataSource(dataSource);
  factoryBean.setPersistenceUnitName("persistenceUnitName");
  factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
  factoryBean.afterPropertiesSet();

  EntityManagerFactory factory = factoryBean.getNativeEntityManagerFactory();