public class Foo {
  private static Rope rope = new Rope();
  private int value;

  public Foo(int value) { this.value = value; }

  @Override public String toString() {
    return "static rope: " + rope + " instance value: " + value;
  }
}