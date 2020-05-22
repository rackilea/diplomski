@Component
public class CustomBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    Reflections reflections = new Reflections("my.package.prefix", new SubTypesScanner(false));
    Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
    for (Class clazz : allClasses) {
      GenericBeanDefinition gbd = new GenericBeanDefinition();
      gbd.setBeanClass(clazz);
      gbd.setAttribute("attributeName", "attributeValue");
      registry.registerBeanDefinition(clazz.getSimpleName() + "RegisteredBean", gbd);
    }
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    // Custom post process the existing bean definitions
  }
}