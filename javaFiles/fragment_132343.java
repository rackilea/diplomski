public void testStartService() throws Exception {

    Intent startServiceIntent = new Intent(getContext(), MyService.class);
    startService(startServiceIntent);
    MyService myService = getService();
    assertNotNull(myService);

    // Run the Looper (this call is to be added)
    Looper.loop();

    Thread.sleep(10000);
}