public class MyApp {
  private static final Logger logger = LogManager.getLogger(MyApp.class);

  public void someMethod(int value) {
    // normal trace-level logging does not include location info
    logger.trace("Doing some work with param {}", value);
    try {
      callAnotherMethod();
    } catch (Throwable t) {
      // use the shared fatal logger to include location info
      LogManager.getLogger("FATAL_LOGGER").fatal("Unexpected error", t);
    }
  }
}