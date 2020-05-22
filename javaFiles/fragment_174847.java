import javax.swing.SwingUtilities;

public class Test {
  public static class ExceptionHandler
                                   implements Thread.UncaughtExceptionHandler {

    public void handle(Throwable thrown) {
      // for EDT exceptions
      handleException(Thread.currentThread().getName(), thrown);
    }

    public void uncaughtException(Thread thread, Throwable thrown) {
      // for other uncaught exceptions
      handleException(thread.getName(), thrown);
    }

    protected void handleException(String tname, Throwable thrown) {
      System.err.println("Exception on " + tname);
      thrown.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
    System.setProperty("sun.awt.exception.handler",
                       ExceptionHandler.class.getName());

    // cause an exception on the EDT
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ((Object) null).toString();        
      }
    });

    // cause an exception off the EDT
    ((Object) null).toString();
  }
}