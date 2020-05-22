public class AuthenticationProcessingFilterAspect {
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationProcessingFilterAspect.class);
  public Object intercept(ProceedingJoinPoint pjp) throws Throwable {
    LOGGER.info("intercept------------------{}",pjp.toLongString());
    //Delegate to customised method instead of default  pjp.proceed()
    return pjp.proceed();
  }
}