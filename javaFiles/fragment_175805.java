public class HasInner {
  public static interface Foo {}

  private static <T> T release(T instance, Object ref) {
    try {
      Class<?> type = instance.getClass();
      for (Field field : type.getFields()) {
        if (!field.isAccessible()) {
          field.setAccessible(true);
        }
        if (field.get(instance) == ref) {
          field.set(instance, null);
        }
      }
    } catch (IllegalAccessException e) {
      throw new IllegalStateException(e);
    }
    return instance;
  }

  public Foo makeFoo() {
    return release(new Foo() {}, this);
  }

  public static void main(String[] args) {
    new HasInner().makeFoo();
  }
}