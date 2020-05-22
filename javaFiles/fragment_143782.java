public class GenericBeanGenerator <T, G> implements BeanFactoryPostProcessor, BeanPostProcessor {

    /**
     * The type of the bean to create
     */
    private Class<T> type;

    /**
     * The list of generic values. Can be String, Class or whatever
     */
    private Iterable<G> generics;

    private Map<String, G> beanNameToGeneric = new HashMap<String, G>();

    public GenericBeanGenerator(Class<T> type, G[] generics) {
        this.type = type;
        this.generics = Arrays.asList(generics);
    }

    public GenericBeanGenerator(Class<T> type, Iterable<G> generics) {
        this.type = type;
        this.generics = generics;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // for each 'generic' value, add a bean definition to the beanFactory with the appropriate bean name
        for(G generic : generics) {
            String beanName = getBeanName(generic);
            beanNameToGeneric.put(beanName, generic);
            ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition(beanName, new AnnotatedGenericBeanDefinition(type) );
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (type.isInstance(bean) && beanNameToGeneric.containsKey(beanName)) {
        @SuppressWarnings("unchecked")
            T instance = (T) bean;
            initiliaze(beanName, beanNameToGeneric.get(beanName), instance);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * Convert a 'generic' value to a string in order to name the bean
     */
    public String getBeanName(G generic) {
        return generic.toString();
    }

    /**
     * Initialize the bean if needed. 
     */
    public void initiliaze(String beanName, G generic, T instance) {

    }
}