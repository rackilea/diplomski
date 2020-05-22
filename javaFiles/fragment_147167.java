class Log4jBackstop implements Thread.UncaughtExceptionHandler {

  private static Logger log = Logger.getLogger(Log4jBackstop.class);

  public void uncaughtException(Thread t, Throwable ex) {
    log.error("Uncaught exception in thread: " + t.getName(), ex);
  }

}