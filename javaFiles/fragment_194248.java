public static void main(String[] args) {

        CommandLineConf conf = new CommandLineConf();
        conf.setIpAddress("127.0.0.1");
        // create root beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // register bean definition for the command line
        ExternalBeanReferneceFactoryBean.setInstance("commandLineConf", conf);
        beanFactory.registerBeanDefinition(
            "commandLineConf",
            BeanDefinitionBuilder.rootBeanDefinition(
                ExternalBeanReferneceFactoryBean.class)
                .getBeanDefinition());

        GenericApplicationContext rootAppContext = new GenericApplicationContext(
            beanFactory);
        rootAppContext.refresh();

        // create the application context
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { 
            "/applicationContext.xml"
        }, rootAppContext);

        InterfacesConfig hazelcastInterface = (InterfacesConfig)appContext.getBean("hazelcastInterface");
        System.out.println(hazelcastInterface.getInterfaces().get(0));

    }