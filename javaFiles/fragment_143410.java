@Test
public void shouldInvokeInnerClassMethod() {
    InnerClass innerMock = Mockito.mock(InnerClass.class);
    TestClass testSubject = new TestClass(innerMock);

    testSubject.methodToTest();

    verify(innerMock).getSomething();
}