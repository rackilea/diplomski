public class AbstractClassTest {
  @Test
  public void testStatusOfChecker() throws Exception {
    MyAbstractClass object = new MyAbstractClass() {
      protected boolean checkStatus() {
        return true; //this is the place to provide the expected value
      }
    }
    boolean status = absClass.validate();
    assertEquals(status, true);
  }
}