@Aspect
@Service
public class StubAspect {

    @Around("execution(public * com.blogspot.nurkiewicz.MyService.foo(..))")
    public Object aroundFoo(ProceedingJoinPoint pjp) throws Throwable {
        if (stubMode()) {
            return //stub foo() result
        }
        return pjp.proceed();
    }

    @Around("execution(public * com.blogspot.nurkiewicz.MyService.bar(..))")
    public Object aroundBar(ProceedingJoinPoint pjp) throws Throwable {
        if (stubMode()) {
            return //stub bar() result
        }
        return pjp.proceed();
    }

    private boolean stubMode() {
        //whatever condition you want here
        return true;
    }

}