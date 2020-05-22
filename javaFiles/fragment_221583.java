@Bean
public SessionFactory sessionFactory() {
    return new LocalSessionFactoryBuilder(dataSource())
            .scanPackages("com.example.entities")
            //.addFile() this should work for your xml files
            .buildSessionFactory();
}