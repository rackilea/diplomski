import java.math.BigDecimal;

public class Test {
  public static void main(String[] args) {
    System.out.println(new BigDecimal(3.14));
    System.out.println(new BigDecimal(3.1400000000000001));
    System.out.println(new BigDecimal(3.1400000000000006));
  }
}