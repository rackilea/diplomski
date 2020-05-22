@Bean
public EntityManagerFactory entityManagerFactory() {
   LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
   em.setDataSource(ds());
   em.setPackagesToScan(new String[] { "org.apache.camel.processor.interceptor.jpa" });
   JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
   em.setJpaVendorAdapter(vendorAdapter);
   return em.getObject();
}