public class Test {
  private boolean stop;

  public static void main(String[] args) throws InterruptedException {
    Test t = new Test();
    new Thread(t::m).start();
//    Thread.sleep(1000);
    System.out.println("stop is now true");
    t.stop = true;
  }

  private void m() {
    while (!stop);
    System.out.println("Finished");
  }

}