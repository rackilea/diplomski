public class Test {

  public static void main(String[] args) {
      Test test = new Test();
      test.runTest();
  }

  public void method1(String s) {
      System.out.println("in method1 with \"" + s + "\"");
  }

  public String method2() {
      return "method2";
  }

  public void runTest() {
      String x; 
      method1(x = method2());
      System.out.println("x=\"" + x + "\"");
  }
}