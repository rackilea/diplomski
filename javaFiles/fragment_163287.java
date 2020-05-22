public class SomeCalculationLogic {
  protected abstract Log getLog();

  public void doCalculation() {
    getLog().info("doing calculations...");
    ...
  }
}

public class BackgroundCalculationLogic extends SomeCalculationLogic {
  private static Log log = LogFactory.getLog(BackgroundCalculationLogic.class);

  protected Log getLog() {
    return log;
  }
}

public class UserRequestCalculationLogic extends SomeCalculationLogic {
  private static Log log = LogFactory.getLog(UserRequestCalculationLogic.class);

  protected Log getLog() {
    return log;
  }
}