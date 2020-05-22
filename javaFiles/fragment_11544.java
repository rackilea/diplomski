import java.math.BigDecimal;

public class Truncate {
  public static void main(String[] args) {
    System.out.println(truncate(new BigDecimal(0.13642351627349847f)));
  }
  public static BigDecimal truncate(BigDecimal number) {
    BigDecimal thousand = new BigDecimal(1000);
    BigDecimal mult = new BigDecimal(number.multiply(thousand).intValue()); 
    BigDecimal result = mult.divide(thousand);
    return result;
  }
}