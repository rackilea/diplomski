@Aspect
@Service
public class StubAspect {

    private MyServiceStub stub = //obtain stub somehow

    @Around("execution(public * com.blogspot.nurkiewicz.MyService.*(..))")
    public Object aroundFoo(ProceedingJoinPoint pjp) throws Throwable {
        if (stubMode()) {
            MethodSignature signature = (MethodSignature)pjp.getSignature();
            Method method = signature.getMethod();
            return method.invoke(stub, pjp.getArgs());
        }
        return pjp.proceed();
    }

    private boolean stubMode() {
        //whatever condition you want here
        return true;
    }

}