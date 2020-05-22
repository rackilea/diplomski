public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    SWIGTYPE_p_p_context ctx_ptr = test.new_context_ptr();
    test.init_context(ctx_ptr);
    SWIGTYPE_p_context ctx = test.context_ptr_value(ctx_ptr);
    // Don't leak the pointer to pointer, the thing it points at is untouched
    test.delete_context_ptr(ctx_ptr);
    test.foo(ctx);
    // Important otherwise it will leak, exactly like C
    test.release_context(ctx);
  }
}