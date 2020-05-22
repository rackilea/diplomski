while(true) {
  long initTime = curTime();
  // this will refresh the GUI and also show any new data from the controller
  refresh(); 
  sleep(curTime()-initTime);
}