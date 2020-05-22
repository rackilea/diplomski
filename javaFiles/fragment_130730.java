@Aspect
@Component
public class LoggingHandler {

     @Before("@annotation(com.example.annotation.Loggable)")
     public void beforeLogging(JoinPoint joinPoint){
         System.out.println("Before running loggingAdvice on method=");

    }

    @After("@annotation(com.example.annotation.Loggable)")
    public void afterLogging(JoinPoint joinPoint){
        System.out.println("After running loggingAdvice on method=");
    }
}