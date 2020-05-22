ConfigurableApplicationContext ctx = SpringApplication.run(ProxyApplication.class, args);
    BeanDefinitionRegistry registry = (BeanDefinitionRegistry) ctx.getAutowireCapableBeanFactory();
    for(String beanName : ctx.getBeanDefinitionNames()){
        System.out.println(beanName);
        registry.removeBeanDefinition(beanName);
    }