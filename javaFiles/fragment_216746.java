@Aspect
public class MyCustomAsspect{

    @AfterReturning(
            pointcut="execution(public * *(..)) and @annotation(MyCustomAnnotation)",
            returning="retVal")
    public void publishMessage(JoinPoint jp, Object retVal) throws Throwable {


    }
}