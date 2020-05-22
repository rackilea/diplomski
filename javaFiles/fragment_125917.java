DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(RunManager.class).addConstructorArgValue(args).getBeanDefinition();
beanFactory.registerBeanDefinition("runManager", beanDefinition);
GenericApplicationContext genericApplicationContext = new GenericApplicationContext(beanFactory);
genericApplicationContext.refresh();
ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] { "application-context.xml" }, genericApplicationContext);