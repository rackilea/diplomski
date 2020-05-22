public interface TestMe<T extends Serializable> {
  Set<T> doSomething();
}

public class A implements TestMe<String> {
  @Override
  public Set<String> doSomething() { ... }
}

public class X implements TestMe<ASerializableObject> {
  @Override
  public Set<ASerializableObject> doSomething() { ... }
}