@Aspect
@Service
class AOP        {
@Around("within(* com.test.*)")
public void calExecTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long t1 = System.currentTimeMillis();
    proceedingJoinPoint.proceed();
    long t2 = System.currentTimeMillis();
    System.out.println("Method "+ proceedingJoinPoint.getSignature().getName() + " time : "+  t2-t1);

    }

   }