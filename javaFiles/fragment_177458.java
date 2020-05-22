public class CheckerTest {
  @Test
  public void test() {
    StatusHelper helper = mock(StatusHelper.class);
    Checker checker = new Checker();
    checker.setHelper(helper);
    when(helper.validate()).thenReturn(true);
    boolean status = checker.validate();
    assertEquals(status, true);
  }
}