public class Test {
  public static void main(String[] args) {
    testit(0.0,0.0);
    testit(0.0, -0.0);
    testit(Double.NaN, Double.NaN);
    testit(Double.NaN, 3.0);
    testit(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    testit(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
  }

  private static void testit(double a, double b) {
    boolean doubleEquals = (a == b);
    boolean doubleCompare = Double.compare(a, b) == 0;
    boolean stringCompare = Double.toString(a).compareTo(Double.toString(b)) == 0;
    if(doubleCompare != stringCompare){
      System.out.print("* ");
    }
    System.out.println("a=" + a + " b=" + b + " double == " + doubleEquals
        + " Double compare " + doubleCompare + " String compare "
        + stringCompare);
  }
}