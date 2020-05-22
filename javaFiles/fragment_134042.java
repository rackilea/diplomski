import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowableInFinalize {
  public static void main(String[] args) throws InterruptedException {
    Thread.setDefaultUncaughtExceptionHandler(
                                          new Thread.UncaughtExceptionHandler() {
      public void uncaughtException(Thread t, Throwable e) {
        Logger.getLogger("ThrowableInFinalize")
              .log(Level.SEVERE, "uncaught exception", e);
      }
    });
    new ThrowableInFinalize();
    System.gc();
    Thread.sleep(1000);
  }

  private final IllegalStateException leftUnclosed = new IllegalStateException(
      "SEVERE: "+getClass().getName()+" was not properly closed after use");
  private boolean safelyClosed;
  @Override
  protected void finalize() throws Throwable {
    if(!safelyClosed) {
      final Thread t = Thread.currentThread();
      t.getUncaughtExceptionHandler().uncaughtException(t, leftUnclosed);
    }
  }
}