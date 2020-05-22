@Aspect // Mark ChangeExistingCode as the class for modifying the code 
@Component
public class ChangeExistingCode {
    private boolean active;

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     *
     * This method will be called by AspectJ anytime a `doSomething` method is called.
     *
     * This will give us a chance to decide whether the `doSomething` method should
     * be called or not.
     *
     */
    @Around("execution(* my.first.spring.aop.aspectj.BaseClass.doSomething(..))")
    public void changeExistingScenario(ProceedingJoinPoint joinPoint) throws Throwable {
        // Is active ?
        if (active) { // Yes, let doSomething() run as usual
            joinPoint.proceed();
        } else {// No, block doSomething() invokation
            Signature s = joinPoint.getSignature();

            System.out.format( //
                    "Blocking instance<%d> method: %s#%s(%s) !!\n", //
                    ((SubClassN)joinPoint.getTarget()).getIndex(), //
                    s.getDeclaringTypeName(), //
                    s.getName(), //
                    Arrays.toString(joinPoint.getArgs()) //
                    );
        }
    }
}