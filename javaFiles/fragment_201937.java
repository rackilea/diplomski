public class Main {
    volatile int a;

  static public final void main (String[] args) throws Exception {
    new Main ().run ();
  }

  private void run () {
      for (int i = 0; i < 1000000; i++) {
        increase ();
      }  
  } 

  private void increase () {
    a++;
  }
}