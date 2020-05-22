public class test {


  public static void main(String[] args) throws InterruptedException{

    ExecServicrunnen x = new ExecServicrunnen();

    // Have ExecServicrunnen run in its own thread:
    new Thread( x ).start();

    Thread.sleep(10000);

    x.getThreadtoStop();

  }

}