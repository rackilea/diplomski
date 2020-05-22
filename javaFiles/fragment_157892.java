AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.addBeanFactoryPostProcessor(new BeanDefinitionRegistryPostProcessor() {

        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            ConstructorArgumentValues cav = new ConstructorArgumentValues();
            cav.addGenericArgumentValue(MyClass.class);

            RootBeanDefinition bean = new RootBeanDefinition(MyFactoryBean.class, cav, null);
            AnnotationBeanNameGenerator generator = new AnnotationBeanNameGenerator();

            registry.registerBeanDefinition(generator.generateBeanName(bean, registry), bean);
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException { }
    });