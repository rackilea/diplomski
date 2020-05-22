@Component
public class ContextHolder implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;

    public void setApplicationContext(ApplicationContext applicationContext) {
        CONTEXT = applicationContext;
    }

    public static ApplicationContext getContext() {
        return CONTEXT;
    }
}