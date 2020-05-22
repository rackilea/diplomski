public class MyTransformer implements IAnnotationTransformer {

  public void transform(ITest annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    if (!annotation.getEnabled()) {
      System.out.println(testClass != null ? testClass : testMethod);
    }
  }
}