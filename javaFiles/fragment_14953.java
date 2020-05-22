@RunWith(JukitoRunner.class)
public class FooTest {
  public static class Module extends JukitoModule {
    @Override
    protected void configureTest() {
      bindMock(TaskExecutor.class).in(TestSingleton.class);
    }
  }

  @Test
  public void testSomething(Foo foo, TaskExecutor executor) {
     foo.doSomething();
     verify(executor, times(2)).someMethod(eq("Hello World"));
  }
}