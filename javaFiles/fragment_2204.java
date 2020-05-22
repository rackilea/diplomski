@Aspect
public class MyLogger {

    private Logger log = Logger.getLogger(getClass());

    @before("execution(* *(..))") // after execution of any function 
    public void log(JoinPoint point) {
      System.out.println(point.getSignature().getName() + " called...");
    }
}