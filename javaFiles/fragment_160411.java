public class Example {
  public void doSomething(int p) {
    if (p == 1) {
      a();
    } else {
      b();
    }
  }

  private void a() {
    System.out.println("a");
  }

  private void b() {
    System.out.println("b");
  }
}