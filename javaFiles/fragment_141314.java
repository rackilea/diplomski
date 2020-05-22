public class Test {
  interface IFoo { }

  static abstract class Helper implements IFoo {
    Helper() { helperMethod(); }
    abstract void helperMethod();
  }

  static class Foo extends Helper {
    private final String aaa;

    Foo(String aaa) { this.aaa = aaa; }

    @Override
    void helperMethod() { System.out.println(String.valueOf(aaa)); }
  }

  public static void main(String[] args) {
    // Call helperMethod twice:
    // once in the Helper.Helper(), once right here.
    new Foo("expected").helperMethod();
    // output:
    //   null
    //   expected
  }
}