@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AspectScanner implements ApplicationListener<ContextRefreshedEvent> {

    public static final Logger LOGGER = LoggerFactory.getLogger(AspectScanner.class);

    public void onApplicationEvent(ContextRefreshedEvent event) {
        final ApplicationContext applicationContext = event.getApplicationContext();
        Map<String, Object> beansOfType = applicationContext.getBeansOfType(Object.class);
        for (Map.Entry<String, Object> entry : beansOfType.entrySet()) {
            boolean advisedWith = isAdvisedWith(applicationContext, entry.getValue(), BeanAspect.class);
            LOGGER.info(entry.getKey() + (advisedWith ? " is advised" : " isn't advised"));
        }
    }

    private static boolean isAdvisedWith(ApplicationContext context, Object bean, Class<?> aspectClass) {
        boolean advisedWith = false;
        HashSet<String> names = new HashSet<>(Arrays.asList(context.getBeanNamesForType(aspectClass)));
        if (bean instanceof Advised) {
            Advisor[] advisors = ((Advised) bean).getAdvisors();
            for (Advisor advisor : advisors) {
                if (advisor instanceof AspectJPrecedenceInformation) {
                    if (names.contains(((AspectJPrecedenceInformation) advisor).getAspectName())) {
                        advisedWith = true;
                    }
                }
            }
        }
        return advisedWith;
    }


    @Aspect
    @Component
    public static class BeanAspect {

        @Before("execution(* test.AspectScanner.Bean*.*(..))")
        public void beforeAny(JoinPoint jp) {

        }

    }

    @Component
    public static class Bean1 {

        public void m() {

        }

    }

    public interface Bean2Intf {

        void m();

    }

    @Component
    public static class Bean2 implements Bean2Intf {

        public void m() {

        }

    }

    @Component
    public static class NotAdvised {

        public void n() {

        }

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectScanner.class);
        context.start();
        context.registerShutdownHook();
    }

}