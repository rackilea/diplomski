public class EmployeeDalModule extends AbstractModule {

  @Override
  protected void configure() {
    ListableBeanFactory beanFactory = new AnnotationConfigApplicationContext(EmployeeDalConfiguration.class).getBeanFactory();
    bind(EmployeeEntityDao.class).toInstance(beanFactory.getBean(EmployeeEntityDao.class));
    bind(EmployeeRepository.class).to(EmployeeRepositoryImpl.class);
  }
}