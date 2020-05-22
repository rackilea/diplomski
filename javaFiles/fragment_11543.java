public class Truncate {
  public static void main(String[] args) {
    System.out.println(truncate(2.123556f));
  }

  public static float truncate(float f) {
    // after casting it to int, it will remove all decimal values.
    // float bigInt = (int) (Math.round(f * 1000)); // prints 2.124 for f=2.123556f
    float bigInt = (int) (f * 1000); // prints 2.123 for f=2.123556f
    float result = bigInt / 1000;

    return result;
  }
}