AutowireCapableBeanFactory factory = ctx.getAutowireCapableBeanFactory();

BeanDefinition definition = new RootBeanDefinition(ActionListenerButton.class);
BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
registry.registerBeanDefinition("addNewButton", definition);
registry.registerBeanDefinition("deleteButton", definition);
factory.initializeBean(addNewButton, "addNewButton");
factory.initializeBean(deleteButton, "deleteButton");