public class DatabaseMigratorDependencyResolver implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

            // Your job is here:
            // Feel free to make use of the methods available from the BeanDefinition class (http://static.springframework.org/spring/docs/2.5.x/api/org/springframework/beans/factory/config/BeanDefinition.html)
            boolean isDependentOnDatabaseMigrator = ...;

            if (isDependentOnDatabaseMigrator) {
                beanFactory.registerDependentBean("databaseMigrator", beanName);
            }
        }
    }

}