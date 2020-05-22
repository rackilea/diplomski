public void testThatMenuWillOpenSettings() {
  // Use false otherwise monitor will block the activity start and resulting waitForMonitorWithTimeout() return null: 
  ActivityMonitor am = getInstrumentation().addMonitor(Activity_Webview_Main.class.getName(), null, false);

  ... ...

  // If you want to see the simulation on emulator or device:
  try {
    Thread.sleep(1000);
  } catch (InterruptedException e) {
    e.printStackTrace();
  }

  Activity a = getInstrumentation().waitForMonitorWithTimeout(am, 1000);
  assertEquals(true, getInstrumentation().checkMonitorHit(am, 1));

  // Check type of returned Activity:
  assertNotNull(a);
  assertTrue(a instanceof Activity_Webview_Main);

  a.finish();

}