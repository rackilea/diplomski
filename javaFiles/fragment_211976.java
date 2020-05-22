@Bean
public SessionFactory sessionFactory() {
    LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
builder
        .scanPackages("com.chaitanya.users.model", "com.chaitanya.department.model")
        .addProperties(getHibernateProperties());

     return builder.buildSessionFactory();
}