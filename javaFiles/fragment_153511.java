@Configuration
public class BeanFactory {
     @Bean
     public LocalSessionFactoryBean sessionFactory() {
         LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setNamingStrategy(getNamingStrategy());
        bean.setMappingResources(Arrays.asList(getPerson());
        bean.setHibernateProperties(new Properties() {{ 
           setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
           setProperty("hibernate.show_sql", "true")
           setProperty("hibernate.hbm2ddl.auto", "create");
        }});
        bean.setDataSource(dataSource());
        return bean;
    }

    @Bean
    public DataSource dataSource() { 
    ....
}