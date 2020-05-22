public class MyTest extends Test {
  @Overwrite
  public void run(TestResult result) {
    super.run(result);
    doSomethingWithResults(result);
  }

  // ...
}