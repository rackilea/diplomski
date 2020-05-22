public class YourTest {
  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void test() {
    ...
    thrown.expect(NullPointerException.class);
    thrown.expectMessage("Oranges was not set.");
    builder.build();
  }
}