public interface IBar<T> {
  public void start(Foo<T> foo);
}

public class Bar<T> implements IBar<T> {

  public void start(final Foo<T> foo) {
    new Thread() {
        @Override
        public void run() {
          while (true) {
            T baz = foo.getT();
            //do something with the T baz object
            foo.callBack();
          }
        }
    }.start();
  }

}

public class Foo<T> {
  private T baz;
  private Bar<T> bar;

  public Foo(T baz, Bar<T> bar) {
    this.baz = baz;
    this.bar = bar;
  }

  public void startBar() {
    bar.start(this); // totally possible
  }

  public T getT() {
    return baz;
  }

  public void callBack() {
    System.out.println("called back");
  }
}