run () {
  try {
    while (Thread.interrupted() == false) {
      doSomeWork();
    }
  } catch (Exception e) { 
    myExecutor.shutdown();
  }
}