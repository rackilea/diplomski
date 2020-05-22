@Aspect
public class ExceptionLogging {

@Around(execution("@annotation(ExceptionHandler)"))
public Object logException(ProceddingJoinPoint pjp){
    String name = pjp.getSignature().getName(); // tweak this as per your requirement
    logger.info("Controller where Exception was raised - " + name);
    Object obj = pjp.proceed();
    return obj;
  }

}