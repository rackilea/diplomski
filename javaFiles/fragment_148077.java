// to test singleton
    BeanDefinitionRegistry registry = (BeanDefinitionRegistry)applicationContext.getAutowireCapableBeanFactory();                                                                                                                                                                                                          
    // registry.getBeanDefinition("myBean").setScope("prototype"); <-- removed this
    BeanDefinition def = registry.getBeanDefinition("myBean");
    def.setScope("prototype"); // or `singleton`                                                                                                                                                                                                                                                                                             
    registry.registerBeanDefinition("myBean", def);

    // it's called from separate thread
    MyBean myBean = applicationContext.getBean("myBean");