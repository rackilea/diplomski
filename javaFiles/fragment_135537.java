public class Heaps {
  public static void main(String[] args) {
    Object probe = new Object();
    for (;;) {
      Object o = new Object();
      if (o.hashCode() == probe.hashCode()) {
        System.out.print(".");
      }
    }
  }
}