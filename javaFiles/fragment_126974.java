public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    // This object behaves exactly like an opaque pointer in C:
    SWIGTYPE_p_context ctx = test.make_context();
    test.foo(ctx);
    // Important otherwise it will leak, exactly like C
    test.release_context(ctx);
  }
}