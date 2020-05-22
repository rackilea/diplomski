public class AnotherClassTestHelper {
  /** Returns a Mockito mock of AnotherClass with a stub for someFunction. */
  public static AnotherClass createAnotherClassMock() {
    AnotherClass mockAnotherClass = Mockito.mock(AnotherClass.class);
    when(mockAnotherClass.someFunction(text)).thenReturn(true);
    return mockAnotherClass;
  }
}