public class Outer {
  private final String message;

  Outer(String message) {
    this.message = message;
  }

  public class Inner {
    private final String message;

    public Inner(String message) {
       this.message = message;
    }

    public void foo() {
      System.out.printf("%s %s%n", Outer.this.message, message);
    }
  }
}