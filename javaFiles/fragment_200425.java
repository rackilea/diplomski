@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(final ApplicationContext appContext) 
                                          throws BeansException {
         ctx = appContext;

    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
}