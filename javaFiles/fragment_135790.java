@Aspect
public class MyAspect {
    private static Logger logger = Logger.getLogger(MyAspect.class.getName());
    @Before("@annotation(com.utils.aop.annotations.MyAnnotation)")
    public void logMyAspect(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        logger.info("Executing method: " + methodName);
    }
}