private static volatile int counter = 0;

private void concurrentMethodWrong() {
  counter = counter + 5;
  //do something
  counter = counter - 5;
}