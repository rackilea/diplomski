class Log4jWrapper {

  private final Logger log;

  private final Runnable target;

  Log4jWrapper(Logger log, Runnable target) { 
    this.log = Objects.requireNonNull(log);
    this.target = Objects.requireNonNull(target); 
  }

  public void run() {
    try {
      target.run();
    } catch(RuntimeException ex) {
      log.error("Uncaught exception.", ex);
      throw ex;
    }
  }

}

...

Runnable realTask = ...;
executor.submit(new Log4jWrapper(Logger.getLogger(Whatever.class), realTask));