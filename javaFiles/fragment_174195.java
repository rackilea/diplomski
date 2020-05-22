@Configuration
public class ObjectMapperConfig {

    @Autowired
    private ConfigurableApplicationContext  context;

    @PostConstruct
    private void init(){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ObjectMapper.class);
        builder.addConstructorArgValue(new JsonFactory());
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) context.getBeanFactory();
        factory.registerBeanDefinition("yamlMapper", builder.getBeanDefinition());
        Map<String, ObjectMapper> beans = context.getBeansOfType(ObjectMapper.class);
        beans.entrySet().forEach(System.out::println);
    }
}