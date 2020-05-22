int cycleCounter = 0;
while (cycleCounter < amountOfCycles) {
  cycleCounter++;
  try {
    //business logic omitted

    barrier.await();

    // And then actually update the values of the cells    
    value += increment;
  } catch (Exception ex) {
    System.err.println("Exception occurred! " + ex);
    ex.printStackTrace();
  }
}