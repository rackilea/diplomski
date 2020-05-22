ConfigurableListableBeanFactory configurableListableBeanFactory = context
        .getBeanFactory();

BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) configurableListableBeanFactory;
// Removing the bean from container
beanDefinitionRegistry.removeBeanDefinition("demo");