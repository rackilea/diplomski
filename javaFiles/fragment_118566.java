public void doSleep(int ms){
  try {
     Thread.sleep(ms);
  }
  catch (InterruptedException ex) {
      … // Handle thread being interrupted. See: https://stackoverflow.com/q/1087475/642706
  }
}