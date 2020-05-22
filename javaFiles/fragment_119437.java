public class YourTest {
  @Test
  public void test() {
    ...
    Throwable exception = exceptionThrownBy(() -> builder.build());
    assertEquals(NullPointerException.class, exception.getClass());
    assertEquals("Oranges was not set.", exception.getMessage());
  }
}