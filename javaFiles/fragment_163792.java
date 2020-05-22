public class AutowireScannedByNameBeanPostProcessor implements BeanFactoryPostProcessor {
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
    Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(name -> {
      BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
      if (beanDefinition instanceof ScannedGenericBeanDefinition) {
        ((ScannedGenericBeanDefinition) beanDefinition).setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
      }
    });
  }
}