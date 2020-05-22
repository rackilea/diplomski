@Configuration
public class SpringConfig {

    @Bean
    public BasicDataSource basicDataSource(){ // org.apache.commons.dbcp2.BasicDataSource Object
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        basicDataSource.setUrl("jdbc:sqlserver://172.125.25.7:1433;databaseName=LIST_FIRMAS;selectMethod=direct;");
        basicDataSource.setUsername("user");
        basicDataSource.setPassword("password");
        return basicDataSource;
    }

    @Bean
    public MyInterceptor myInterceptor(){  // Your interceptor
        return new MyInterceptor();
    }

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() throws IOException{
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        localSessionFactoryBean.setDataSource(basicDataSource()); // DataSource

        localSessionFactoryBean.setAnnotatedClasses(
                com.isapeg.timbrado.model.SalMinimo.class,
                com.isapeg.timbrado.model.DeduccionCnom12.class,
                com.isapeg.timbrado.model.PercepcionCnom12.class); // JPA entity classes ....

        localSessionFactoryBean.setEntityInterceptor(myInterceptor()); // Setting your Interceptor

        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
        properties.put("hibernate.current_session_context_class", "thread");
        properties.put("hibernate.show_sql", "false");
        localSessionFactoryBean.setHibernateProperties(properties);  // Setting Hibernate Properties

        localSessionFactoryBean.afterPropertiesSet();  // Session Factory initialization

        return localSessionFactoryBean.getObject();  // Returning of SessionFactory Object
    }

    // other beans ....
}