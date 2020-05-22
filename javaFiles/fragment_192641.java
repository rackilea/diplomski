public class Foo {

  @Delegate(IBar.class)
  private Bar bar;

  // initialize bar via constructor or setter
}