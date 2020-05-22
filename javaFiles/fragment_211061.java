import java.math.BigDecimal;

public class Test {
  public static void main(String[] args) {
    BigDecimal exactValue = new BigDecimal("1.5000000596046447753906251");
    System.out.println("Exact = " + exactValue);

    double d = 1.5000000596046447753906251;
    BigDecimal dValue = new BigDecimal(d);
    System.out.println("dValue = " + dValue);

    float f1 = 1.5000000596046447753906251f;
    BigDecimal f1Value = new BigDecimal(f1);
    System.out.println("f1Value = " + f1Value);

    float f2 = (float) 1.5000000596046447753906251;
    BigDecimal f2Value = new BigDecimal(f2);
    System.out.println("f2Value = " + f2Value);

    System.out.println("f1 error = "
        + exactValue.subtract(f1Value).abs());
    System.out.println("f2 error = "
        + exactValue.subtract(f2Value).abs());
  }
}