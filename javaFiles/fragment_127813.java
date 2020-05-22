public class Foo {

  public static void main(String... args) {
    new Thread(ignoreInterruption(Foo::bar)).start();
    new Thread(ignoreInterruption(() -> Foo.baz(1, 2, 3))).start();
  }

  static void bar() throws InterruptedException {
    // do something
    Thread.sleep(1000);
  }

  static void baz(int a, int b, int c) throws InterruptedException {
    // do something
    Thread.sleep(1000);
  }  

  interface Interruptible {
    public void run() throws InterruptedException;
  }

  static Runnable ignoreInterruption(Interruptible interruptible) {
    return () -> { 
      try {
        interruptible.run();
      }
      catch(InterruptedException ie) {
        // ignored
      }
    };
  }

}