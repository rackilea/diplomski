ApplicationListener listener = new ApplicationListener() {
     public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
           ContextRefreshedEvent cre = (ContextRefreshedEvent) event;
           ConfigurableListableBeanFactory autowireCapableBeanFactory = (ConfigurableListableBeanFactory) cre
                 .getApplicationContext().getAutowireCapableBeanFactory();
           new SpringBeanProcessor(dispatcher, registry, providerFactory)
                 .postProcessBeanFactory(autowireCapableBeanFactory);
        }
     }
  };
  configurableWebApplicationContext.addApplicationListener(listener);