public class TestA
{
  private static final String VALUE_ABC = "VALUE_ABC";

  private A classToTest;

  @Test
  public void testFoo()
  {
    classToTest.foo();
  }

  @Before
  public void preTestSetup()
  {
    classToTest = new A();

    ReflectionTestUtils.setField(
      classToTest,
      "abc",
      VALUE_ABC)
  }
}