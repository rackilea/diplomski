@Bean 
class SessionFactoryBean implements FactoryBean<SessionFactory> {
    private EntityManagerFactory emf;
    private SessionFactory sessionFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
        sessionFactory = ((HibernateEntityManagerFactory) emf).getSessionFactory();
    }
    public SessionFactory getObject() {
        return sessionFactory;
    }
}