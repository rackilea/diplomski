@Service
public class ServiceLocator {

    @Autowired
    private static ApplicationContext appContext;

    @Autowired
    public ServiceLocator(ApplicationContext appContext) {
        ServiceLocator.appContext = appContext;
    }

    public static <T> T getClassFromSpringContainer(Class<T> clazz) {
        return appContext.getBean(clazz);
    }

}