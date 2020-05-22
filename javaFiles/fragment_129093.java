public abstract class My {
  public Result methodUnderTest() { ... }
  protected abstract void methodIDontCareAbout();
}

public class MyTest {
    @Test
    public void shouldFailOnNullIdentifiers() {
        My my = Mockito.mock(My.class, Mockito.CALLS_REAL_METHODS);
        Assert.assertSomething(my.methodUnderTest());
    }
}