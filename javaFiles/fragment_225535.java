@Aspect
public class RestAspect {

  @Pointcut(
    "call(* java.util.logging.Logger.log(..)) "
    + "&& args(*, logMessage)"
    + "&& cflow(execution(* com.gg.spring.tests.services.ServiceImpl.returnData(..))) "
    + "&& cflow(execution(* com.gg.spring.tests.rest.TestRestController.callService(..)))"
    + "&& !within(RestAspect)")
  private void logPointcut(String logMessage) { }

  @Pointcut(
    "call(com.gg.spring.tests.rest.RestResponse.new()) "
    + "&& cflow(execution(* com.gg.spring.tests.rest.TestRestController.callService(..)))"
    + "&& !within(RestAspect)")
  private void afterConstructingResponsePointcut() {}

  private ThreadLocal<List<String>> messages = new ThreadLocal<>();

  @Around("logPointcut(logMessage)")
  public void loggerCall(ProceedingJoinPoint joinPoint, String logMessage) {
    this.messages.get().add(logMessage);
  }

  @AfterReturning(returning = "response", pointcut = "afterConstructingResponsePointcut()")
  public void firstCall(JoinPoint jp, RestResponse<String> response) {
    this.messages.set(response.getMessages());
  }
}