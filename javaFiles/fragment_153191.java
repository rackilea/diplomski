public class MyHandler extends Handler {
  private final static String className = MyHandler.class.getName();
  private final static Logger logLogger = Logger.getLogger(className);
  ...

  @Override
  public void publish(LogRecord record) {
    if (!super.isLoggable(record)) {
      return;
    }

    String loggerName = record.getLoggerName(); //EDIT: Was getSourceClassName before
    if (loggerName != null && loggerName.equals(className)) {
      // This is our own log line; returning immediately to prevent endless loops
      return;
    }

    try {
      // ... do actual handling...
    } catch(Exception e) {
      logLogger.logp(level.SEVERE, className, "publish", "something went wrong", e);
    }
  }
}