public class A {
  private static final Set<Class<?>> INSTANTIATED_CLASSES = new HashSet<Class<?>>();

  public A() {
    if (!INSTANTIATED_CLASSES.add(this.getClass())) {
      throw new IllegalStateException("Oh no! " + this.getClass() + " was already instantiated once!");
    }
  }
}