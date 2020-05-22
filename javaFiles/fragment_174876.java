public interface TestInterface {
  public List testMethod();
}
public class TestClass implements TestInterface {
  @Override
  public List testMethod() {
      return Collections.singletonList(1);
  }
}