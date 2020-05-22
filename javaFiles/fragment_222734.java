import org.testng.annotations.Factory;

public class MyTestClassFactory {

  @Factory
  public static Object[] createTestClassInstances() {
    return new Object[] {
      new SampleTestClass(new VariantOne()), new SampleTestClass(new VariantTwo())
    };
  }
}