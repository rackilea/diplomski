public class MockitoStubTest3 {
  @Test
  public void testStubbing() {
    MyInterface myInterface = mock(MyInterface.class);
    when(myInterface.someMethod(isA(MyClass.class) as MyClass)).thenReturn("foobar");
    assertEquals("foobar", myInterface.someMethod(new MyClass()));
  }

  private interface MyInterface {
    String someMethod(MyClass arg);
    String someMethod(String arg);
  }

  private static class MyClass {}
}