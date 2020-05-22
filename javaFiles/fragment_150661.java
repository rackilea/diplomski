@Test
public void testAPI() throws Exception  {

    // configure you TestMyApplication
    assertTrue(MyApplication.getInstance() instanceof TestMyApplication);
    TestMyApplication testMyApp = (TestMyApplication) MyApplication.getInstance();
    testMyApp.setCPSharedService(this.mockApi);

    activity.populateFields();
    activity.validateFields();
    activity.register("");

    Mockito.verify(this.mockApi).register(Mockito.anyMap(), cb.capture());

    ...

}