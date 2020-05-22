public class EventBusRegisterBeanPostProcessor implements BeanPostProcessor,
        ApplicationContextAware {

    private ApplicationContext context;

    @Autowired
    private EventBus eventBus; // The only event bus i assume...

    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {

        if (bean instanceof ILanguageChangeListener) {
            registerToEventBus(bean);
        }

        return bean;
    }

    private void registerToEventBus(Object bean) {
        this.eventBus.register(bean);
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = applicationContext;
    }

}