public interface IO <A> {
  public A run ();
}

public final class Pure <A> implements IO <A> {
  private final A val;
  Pure (A x) { val = x; }
  public A run () {
      return val;
      }
}