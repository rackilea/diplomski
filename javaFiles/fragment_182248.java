// Be sure to add @Aspect and @Component
@Component
@Aspect
public class DemoAop {

  private static Logger logger = LoggerFactory.getLogger(DemoAop.class);

  @Pointcut("within(@org.springframework.stereotype.Controller *)")
  public void controller() {
  }

  @Pointcut("execution(* *.*(..))")
  protected void allMethod() {
  }

  @Before("controller()&& allMethod()")
  public void logBefore(JoinPoint joinPoint) {
    logger.info("TEST");
  }

}