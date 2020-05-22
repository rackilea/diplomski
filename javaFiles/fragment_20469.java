public static void main(String[] args) {
  try {
    MyClassToLoad c = new MyClassToLoad();
  } catch (java.lang.NoClassDefFoundErro e) {
    e.getCause().printStackTrace();
  }
}