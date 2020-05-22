public static class Child {}

public static class Processor implements BeanPostProcessor {        
    @Autowired
    public Child child;             
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null; // Spring would complain if this was executed
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null; // Spring would complain if this was executed
    }       
}

@Configuration
public static class Config {
    @Bean
    public static Processor processor() {
        return new Processor();
    }
    @Bean
    public Child child() {
        return new Child();
    }
}

public static void main(String[] args) throws IOException, ParseException, JAXBException, URISyntaxException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {     
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    Processor processor = context.getBean(Processor.class);
    System.out.println(processor.child);
}