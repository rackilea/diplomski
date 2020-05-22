private static boolean loaded = false;
private static native void nativeMyTest();
public static void myTest() {
  if(!loaded) {
    loaded = true;
    loadLibrary();
  }
  nativeMyTest();
}