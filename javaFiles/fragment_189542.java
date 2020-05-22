public class MyMainClass {

  private static boolean standalone = false;

  public static boolean isStandalone() {
    return standalone;
  }

  public static void main(String[] args) {
    standalone = true;

    // Run as usual...

  }

}