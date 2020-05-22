class AWTExceptionHandler {

  public void handle(Throwable t) {
    try {
      // insert your exception handling code here
      // or do nothing to make it go away
    } catch (Throwable t) {
      // don't let the exception get thrown out, will cause infinite looping!
    }
  }

  public static void registerExceptionHandler() {
    System.setProperty('sun.awt.exception.handler', AWTExceptionHandler.class.getName())
  }
}