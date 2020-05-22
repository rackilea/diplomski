@Test
public void testDoWork() throws Exception{

    MyTest mytest = new MyTest();

    OtherObj obj = new OtherObj();
    obj.test="mocked Test"; //here you can add any other needed values to obj

    PowerMockito.whenNew(OtherObj.class).withNoArguments().thenReturn(obj);

    String result = mytest.doWork();
    Assert.assertTrue(result.equalsIgnoreCase("mocked Test"));
}