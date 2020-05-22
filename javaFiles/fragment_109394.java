public class Singleton {

  private Singleton() {}

  public synchronized static Singleton getInstance() { ... }

  private int counter = 0;

  public void addToCounter(int val) {
    counter += val;
  }
}