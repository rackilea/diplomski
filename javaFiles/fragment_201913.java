public class Test {
  public static void main(String[] argv) {
    System.out.println("mem: " + Runtime.getRuntime().freeMemory());
    System.out.println("total mem: " + Runtime.getRuntime().totalMemory());
  }
}