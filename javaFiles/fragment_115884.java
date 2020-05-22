@PrepareForTest({...,..., XXX.class})
...
@Test
public void testMethodToBeTested(){
    XXX mockInstance = PowerMock.createMock(XXX.class); 
    ...
    PowerMock.expectNew(XXX.class, p1, p2, p3, p4, p5).andReturn(mockInstance);
    mockInstance.methodWithNoReturnVal();
    expect(mockInstance.getSearchVal()).andReturn(1);
    PowerMock.replay(mockInstance, XXX.class);
    Whitebox.invokeMethod(objInstance, "methodToBeTested");

    PowerMock.verify(mockInstance);
}