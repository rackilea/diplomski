public abstract class GetAndParse<T extends AnotherClass> {
  public SomeClass var;

  public abstract void getAndParse(T... args);
}

public class Implementor extends GetAndParse<SpecificClass> {
  // some field declarations

  // some method declarations

  @Override
  public void getAndParse(SpecificClass... args) {
    // method body making use of args
  }
}