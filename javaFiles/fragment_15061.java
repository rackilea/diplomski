public static void timeTakenFunc(Consumer<int[]> func, int[] A) {
  long startTime = System.nanoTime();

  //placeholder for foo and bar function here
  func.accept(A);

  long endTime = System.nanoTime();
  long duration = ((endTime - startTime) / 1000000);
  System.out.println("function took: " + duration + "milliseconds");
}