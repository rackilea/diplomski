public class MyControllerTest {

  private MyController myController;
  private final String SLICE_NAME = "Hello World";
  private final String expected = "hello world";

  @Test
  public void shouldReturnSanitizedString() throws Exception {
  String actual = myController.covertToLowerCase(SLICE_NAME);
  // assert that actual and expected are same
  assertEquals(expected, actual);
  }
}