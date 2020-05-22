@Test
public void shouldAddSomething() {
    ArgumentCaptor<Something> somethingCaptor = ArgumentCaptor.forClass(Something.class);
    Something somethingMock = Mockito.mock(Something.class);
    InnerClass innerMock = Mockito.mock(InnerClass.class);
    when(innerMock.getSomething()).thenReturn(somethingMock);
    TestClass testSubject = new TestClass(innerMock);

    testSubject.methodToTest();

    verify(somethingMock).addSomething(somethingCaptor.capture());
    Something addedSomething = somethingCaptor.getValue();
    //assertions on addedSomething content
}