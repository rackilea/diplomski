public class Child implements Runnable {
  private Parent parent;

  public Child(Parent parent) { this.parent = parent; }

  public void run() {
    // what the thread does goes in here...
  }