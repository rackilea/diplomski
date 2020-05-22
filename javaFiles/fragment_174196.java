@Autowired
private DefaultListableBeanFactory beanFactory;

@PostConstruct
private void init(){
    BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(YAMLMapper.class);
    beanFactory.registerBeanDefinition("yamlMapper", builder.getBeanDefinition());
}