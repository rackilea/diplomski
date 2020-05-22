@Bean
public HibernateInterceptor hibernateInterceptor(
            LocalContainerEntityManagerFactoryBean factory) {
    HibernateInterceptor hibernateInterceptor = new HibernateInterceptor();
    if(factory.getNativeEntityManagerFactory() == null)
            throw new NullPointerException("This shouldn't happen");
    // rest of your code and use factory variable rather than entityManagerFactory()