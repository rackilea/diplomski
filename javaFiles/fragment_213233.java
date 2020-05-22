@Configuration
public class AppConfiguration {
    @Autowired
    private BeanFactory beanFactory;

    public ServiceLocatorFactoryBean myFactoryLocator() {
        final ServiceLocatorFactoryBean locator = new ServiceLocatorFactoryBean();
        locator.setServiceLocatorInterface(MyFactory.class);
        locator.setBeanFactory(beanFactory);
        return locator;
    }

    @Bean
    public MyFactory myFactory() {
        final ServiceLocatorFactoryBean locator = myFactoryLocator();
        locator.afterPropertiesSet();
        return (MyFactory) locator.getObject();
    }
}