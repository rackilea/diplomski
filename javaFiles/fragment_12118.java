@Bean
    public DwrController dwrController(ApplicationContext applicationContext){

        BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry)applicationContext.getAutowireCapableBeanFactory();
        Map<String,String> configParam = new HashMap<String, String>();
        configParam.put("activeReverseAjaxEnabled","true");

        ClassPathBeanDefinitionScanner scanner = new DwrClassPathBeanDefinitionScanner(beanDefinitionRegistry);
        scanner.addIncludeFilter(new AnnotationTypeFilter(RemoteProxy.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(DataTransferObject.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(GlobalFilter.class));
        scanner.scan("package.to.scan");

        DwrController dwrController = new DwrController();
        dwrController.setDebug(true);
        dwrController.setConfigParams(configParam);

        SpringConfigurator springConfigurator = new SpringConfigurator();
        List<Configurator> configurators = new ArrayList<Configurator>();
        configurators.add(springConfigurator);
        dwrController.setConfigurators(configurators);


        return dwrController;
    }
    @Bean
    public BeanNameUrlHandlerMapping beanNameUrlHandlerMapping(){
        BeanNameUrlHandlerMapping beanNameUrlHandlerMapping = new BeanNameUrlHandlerMapping();
        return beanNameUrlHandlerMapping;
    }
    @Bean
    public DwrHandlerMapping dwrHandlerMapping(DwrController dwrController){
        Map<String,DwrController> urlMap = new HashMap<String, DwrController>();
        urlMap.put("/dwr/**/*",dwrController);

        DwrHandlerMapping dwrHandlerMapping = new DwrHandlerMapping();
        dwrHandlerMapping.setAlwaysUseFullPath(true);
        dwrHandlerMapping.setUrlMap(urlMap);
        return dwrHandlerMapping;
    }