public static void timeTakenFunc(Runnable func) {
  long startTime = System.nanoTime();

  //placeholder for foo and bar function here
  func.run();

  long endTime = System.nanoTime();
  long duration = ((endTime - startTime) / 1000000);
  System.out.println("function took: " + duration + "milliseconds");
}