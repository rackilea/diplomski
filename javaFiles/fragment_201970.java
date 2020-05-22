public final class Singleton {
  private static Singleton singleton = null;

  public static synchronized Singleton getInstance() {
    if (singleton == null) {
        singleton = new Singleton();
    }
    return singleton;
  }

  private Singleton() {
    if (!new File("maybeIExist.txt").exists()) {
        throw new ExceptionInInitializerError();
    }
  }

  public void doStuff() {
    System.out.println("stuff");
  }
}