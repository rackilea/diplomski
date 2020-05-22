@Test
public void testMyPrivateMethod() {
    //1. object with the logic to test
    A a = new A();

    //2. set up mocking
    Obj mockObj = createMock(Obj.class);
    expectNew(Obj.class).andReturn(mockObj);

    //3. trigger logic to test
    a.someOtherMethodThatCallsMethod1();

    //4. test Obj (find out if setX() has been called or not)
    verify(mockObj).setX(any(Integer.class));
}