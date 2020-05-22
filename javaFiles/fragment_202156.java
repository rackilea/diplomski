public static void main(String[] args) {
  boolean ok = false;
  while (!ok) {
    try {
      Application.start();
      ok = true;
    } catch (Exception e) {
      // error message
    }
}