public class FooTest {
  @Test(timeout = 10000)
  public void timeoutTest() throws Exception {
    throw new InterruptedException("hello");
  }
}