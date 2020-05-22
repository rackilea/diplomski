int keyToPress = ...;
int timeToPress = ...;

Robot r = new Robot();
r.keyPress(keyToPress);
Thread.sleep(timeToPress);
r.keyRelease(keyToPress);