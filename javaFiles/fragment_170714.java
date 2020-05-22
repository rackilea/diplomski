class Foo {

  // the constants
  public static final Foo RHUBARB = new Foo();
  public static final Foo CUSTARD = new Foo();

  // only this class and subclasses can create constants
  protected Foo(){ }
}