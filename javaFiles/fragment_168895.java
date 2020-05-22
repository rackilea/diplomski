import java.math.BigDecimal;

class Test {
  public static void main(String[] args) {
    double d = -130.98999999999069;
    BigDecimal dDec = new BigDecimal(d);
    System.out.println("Printed as double: "+d);
    BigDecimal down = new BigDecimal(Math.nextAfter(d, Double.NEGATIVE_INFINITY));
    System.out.println("Next down: " + down);
    System.out.println("Half down: " + down.add(dDec).divide(BigDecimal.valueOf(2)));
    System.out.println("Original: " + dDec);
    BigDecimal up = new BigDecimal(Math.nextAfter(d, Double.POSITIVE_INFINITY));
    System.out.println("Half up: " + up.add(dDec).divide(BigDecimal.valueOf(2)));
    System.out.println("Next up: " + up);
    System.out.println("Original in hex: "+Long.toHexString(Double.doubleToLongBits(d)));
  }
}