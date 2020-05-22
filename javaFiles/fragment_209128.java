@Test
public void test()  {

  A arg0, arg1;

  // Case 1
  arg0 = EasyMock.createMock(A.class);
  arg1 = EasyMock.createMock(A.class);

  // expectations
  EasyMock.expect(arg0.getName()).andReturn(null).once();
  EasyMock.expect(arg1.getName()).andReturn(null).once();
  EasyMock.replay(arg0, arg1);

  // actuals
  String expectedValue = null;
  String output = foo(arg0, arg1);

  // assertions
  Assert.assertEquals(expectedValue, output);


  // Case 2
  arg0 = EasyMock.createMock(A.class);
  arg1 = EasyMock.createMock(A.class);

  // expectations
  EasyMock.expect(arg0.getName()).andReturn("Jack").once();
  EasyMock.expect(arg0.getId()).andReturn(1).once();
  EasyMock.expect(arg1.getName()).andReturn(null).once();
  EasyMock.replay(arg0, arg1);

  // actuals
  expectedValue = "Value 1";
  output = foo(arg0, arg1);

  // assertions
  Assert.assertEquals(expectedValue, output);


  // Case 3
  arg0 = EasyMock.createMock(A.class);
  arg1 = EasyMock.createMock(A.class);

  // expectations
  EasyMock.expect(arg0.getName()).andReturn(null).once();
  EasyMock.expect(arg1.getName()).andReturn("Paul").once();
  EasyMock.expect(arg1.getId()).andReturn(2).once();
  EasyMock.replay(arg0, arg1);

  // actuals
  expectedValue = "Value 2";
  output = foo(arg0, arg1);

  // assertions
  Assert.assertEquals(expectedValue, output);
}