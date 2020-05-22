Thread thread = new Thread() {
  @Override
  public void run() {
    runPlannedTestSets.findAndRunTestSet(waitingTestSet, availableHost));
  } 
}

thread.start();