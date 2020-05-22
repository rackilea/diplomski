AutowireCapableBeanFactory factory = wac.getAutowireCapableBeanFactory();
BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
registry.removeBeanDefinition(beanId);

//create newBeanObj through GenericBeanDefinition

registry.registerBeanDefinition(beanId, newBeanObj);