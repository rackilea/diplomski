@Test
public void testAnyMethod() {

    // ...

    SomeClass mockSomeClass = mock(SomeClass.class);
    when(mockSomeClass).someMethod(anArgument).thenReturn(someResult);

    // The problem is that .getBean("SomeClass") returns Object.class which is then cast
    // to SomeClass in anyMethod. If I return an Object then someMethod(anArgument) dosent exist

    ApplicationContext mockApplicationContext = mock(ApplicationContext.class);
    when(mockApplicationContext.getBean("SomeClass", SomeClass.class)).thenReturn(mockSomeClass);

    // ...
}