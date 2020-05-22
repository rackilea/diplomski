@Configuration
    @Aspect
    public class ValidatingAdvices {

    @Before(value = "execution(* com.my.ms.tst.api.*.get*(..))")
    public void validateKey(JoinPoint joinPoint) throws Throwable {
         System.out.println("Executing the before advice");
     }

    }