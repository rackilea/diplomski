public class Test {
  public static void main(String[] args) {
    int size = Integer.parseInt(args[0]);

    long before = getUsedMemory();
    int[] array = new int[size];
    long after = getUsedMemory();

    long difference = after - before;
    System.out.println("Total difference: " + (after - before));
    System.out.println("Per element: " + ((double) difference) / size);
    System.out.println(array); // Make sure the array isn't GC'd early
  }

  private static long getUsedMemory() {
    Runtime rt = Runtime.getRuntime();
    return rt.totalMemory() - rt.freeMemory();
  }
}