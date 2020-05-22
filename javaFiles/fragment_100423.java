class SafeDeposit {
  private static SafeDeposit sd;
  public static SafeDeposit getInstance() {
    if(sd == null) sd = new SafeDeposit();
    return sd;
  }
  private SafeDeposit() { }

  static void warmup() {
    for (int i = 0; i < 100_000; i++) getInstance();
    sd = null;
  }
}

public class PrivCon {
  public static void main(String[] args) {
    SafeDeposit.warmup();
    SafeThief wizard = new SafeThief();
    for(int i = 0; i < 10; i ++) new Thread(wizard).start();
  }
}

class SafeThief implements Runnable {
  public void run() {
    try { Thread.sleep(100); } catch (InterruptedException e) {  }
    System.out.println(SafeDeposit.getInstance().toString());
  }
}