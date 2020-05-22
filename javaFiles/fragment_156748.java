public class Bar {
  private final Helper<?> helper;
  public Bar(Foo<?> foo) {
    this.helper = Helper.create(foo);
  }
  public void startStuff() {
    helper.startStuff();
  }
  public void finishStuff() {
    helper.finishStuff();
  }
  private static class Helper<T> {
    private final Foo<T> foo;
    private T t;
    private Helper(Foo<T> foo) {
      this.foo = foo;
    }
    static <T> Helper<T> create(Foo<T> foo) {
      return new Helper<T>(foo);
    }
    void startStuff() {
      t = foo.getOne();
    }
    void finishStuff() {
      foo.useOne(t);
    }
  }
}