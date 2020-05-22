public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    context ctx = new context();
    // You can't count on the finalizer if it exits:
    ctx.delete();
    ctx = null;
    // System.gc() might also do the trick and in a longer
    // running app it would happen at some point probably.
  }
}