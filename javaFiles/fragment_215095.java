public class MyLogger {
  private static Logger logger = LoggerFactory.getLogger("application");

  public static void debug(String s) {logger.debug(s));}

  public static void debug(Class<?> caller, String s) {
     LoggerFactory.getLogger(caller.getName()).debug(s);
  }

  // ...
}