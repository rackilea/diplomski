@Test
public void testExecute(){
    Customer custMock = createMock(Customer.class);     
    expect(custMock.getAccount()).andReturn("1111").times(1);
    replay(custMock);

    Foo foo = EasyMock.createMockBuilder(Foo.class)
                      .addMockedMethod("method1")
                      .addMockedMethod("method2")
                      .createMock();
    foo.execute();

    verify(custMock);
}