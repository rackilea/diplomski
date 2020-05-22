public static class WatchmanTest {
  private static String watchedLog;

  @Rule
  public TestWatcher watchman= new TestWatcher() {
    @Override
    protected void failed(Throwable e, Description description) {
       String methodName = description.getMethodName();
       System.out.println("--------------Failed Test " + methodName + "-----------");   
    }

    @Override
    protected void starting(Description description) {
       String methodName = description.getMethodName();
       System.out.println("--------------Testing " + methodName + "-----------");   
    }

    @Override
    protected void succeeded(Description description) {
       String methodName = description.getMethodName();
       System.out.println("--------------Successfully Tested " + methodName + "-----------");
    }
 };

  @Test
  public void fails() {
      fail();
  }

  @Test
  public void TestXYZ() {
      // actual test logic here
      // ...
  }

  @Test
  public void Test123() {
      // actual test logic here
      // ...
  }