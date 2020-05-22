public class BeanProvider {

    private static ApplicationContext applicationContext;

    /**
     * Autowires the specified object in the spring context
     * 
     * @param object
     */
    public static void autowire(Object object) {
        applicationContext.getAutowireCapableBeanFactory().autowireBean(object);
    }

    @Autowired
    private void setApplicationContext(ApplicationContext applicationContext) {
        BeanProvider.applicationContext = applicationContext;
    }

}