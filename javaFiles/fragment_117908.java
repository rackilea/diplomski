public void someMethod() {
  int index;
  if (cond1) {
    if (cond2) {
      methodXForTheFirstCycle();
      for (int j = 1; j < 10; j++) {
        methodXForTheRestCycles();
      }
    } else {
      methodYForTheFirstCycle();
      for (int j = 1; j < 10; j++) {
        methodYForTheRestCycles();   
      }
    }
  }
}