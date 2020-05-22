public class ExampleTest extends TestCase {
  private static int num = 1;

  private Foo foo;  

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    foo = new Foo(num++);
  }

  public void testA() {
    foo.printNum();
  }

  public void testB() {
    foo.printNum();
  }

  private static class Foo {
    private final int num;

    public Foo(int num) {
      this.num = num;
    }

    public void printNum() {
      System.out.println(num);
    }
  }
}