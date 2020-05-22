@Test(guiceModule = GuiceExampleModule.class)
public class GuiceTest {

  @Inject
  ExternalDependency dependency;

  @Test
  public void singletonShouldWork() {
    Assert.assertTrue(true, dependency.shouldExecute());
  }
}