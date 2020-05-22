public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    int[] arr = new int[100000];
    test.populate(arr);
    // Only print 40 to avoid spamming my screen!
    for (int i = 0; i < 40; ++i) {
      System.out.println(arr[i]);
    }
  }
}