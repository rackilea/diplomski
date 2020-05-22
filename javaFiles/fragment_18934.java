public abstract class Foo {

  protected abstract int getValue();

  public final void doTheFoo() {
    int value = getValue();
    ... do something ...
  }