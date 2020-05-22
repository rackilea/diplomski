public class test_app {
  public static int add(int a, int b) {
    return test_appJNI.add(a, b);
  }

  public static int add_pointer(SWIGTYPE_p_int a, SWIGTYPE_p_int b) {
    return test_appJNI.add_pointer(SWIGTYPE_p_int.getCPtr(a), SWIGTYPE_p_int.getCPtr(b));
  }

  public static String print_hello() {
    return test_appJNI.print_hello();
  }

}