public abstract class Base {
  public static Base create() {
    return new DefaultBase();
  }

  public abstract void frobnicate();

  static class DefaultBase extends Base {
    public void frobnicate() {
      // default frobnication implementation
    }
  }
}