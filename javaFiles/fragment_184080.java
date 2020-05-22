public class HibernateStatisticsFactoryBean implements FactoryBean<Statistics> {

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  @Override
  public Statistics getObject() throws Exception {
    SessionFactory sessionFactory = ((HibernateEntityManagerFactory) entityManagerFactory).getSessionFactory();
    return sessionFactory.getStatistics();
  }

  @Override
  public Class<?> getObjectType() {
    return Statistics.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}