context.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerSingleton("webMvcConfigDetails", webMvcConfigDetails);
    }});