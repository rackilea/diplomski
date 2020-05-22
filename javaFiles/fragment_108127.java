StopWatch s = new StopWatch();
s.start();
while (selenium.isElementPresent("element_locator")) {
   selenium.setSpeed("10");
   Thread.sleep(10);
}
s.stop();
System.out.println("elapsed time in milliseconds: " + s.getElapsedTime());