final class Test {

  public static void main(String[] argv) throws InterruptedException {
    AtomicInteger shared = new AtomicInteger();
    Thread a = new B(shared).start();
    a.join();
    Thread b = new C(shared).start();
    b.join();
  }

}

final class B extends Thread {

  private final AtomicInteger shared;

  B(AtomicInteger shared) { this.shared = shared; }

  @Override()
  public void run() {
    shared.getAndIncrement();
    shared.getAndIncrement();
  }

}

final class C extends Thread {

  private final AtomicInteger shared;

  C(AtomicInteger shared) { this.shared = shared; }

  @Override()
  public void run() {
    System.out.println(shared.get());
  }

}