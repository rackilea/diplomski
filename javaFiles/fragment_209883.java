public void testClock() throws InterupteExcdeption {

  Clock testClock = new Clock();
  long time1 = testClock.getCurrentTime();
  Thread.sleep(1000);
  long time2 = testClock.getCurrentTime();
  assertTrue(time2 > time1);


}



 public void testClock2() throws InterupteExcdeption {

      Clock testClock = new Clock();
      long time1 = testClock.getCurrentTime();
      Thread.sleep(1000);
      long time2 = testClock.getCurrentTime();
      assertTrue(time2 - time1 > 800);

      long time3 = testClock.getCurrentTime();
      long time4 = testClock.getCurrentTime();

      // expecting a value of 0, but make the test defensive, use 100ms
      assertTrue(time4 - time3 < 100);


    }