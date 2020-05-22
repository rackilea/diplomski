public class jsp_problem_steps
{
  public static void main(String[] args)
  {
    Long currentUsage=209715200l; // 209715200l
    BigDecimal totalQuota = new BigDecimal("343597383680"); // 343597383680

    BigDecimal coerced = new BigDecimal("1024");

    BigDecimal t = totalQuota.divide(coerced, BigDecimal.ROUND_HALF_UP).divide(coerced, BigDecimal.ROUND_HALF_UP).divide(coerced, BigDecimal.ROUND_HALF_UP);
    System.out.println("coerced BigDecimal quota : " + t);

    Double d = currentUsage.doubleValue() / 1024d / 1024d;

    System.out.println("coerced Double usage : " + d);

    BigDecimal coerced_d = (new BigDecimal(d));

    System.out.println(coerced_d + " at scale " + coerced_d.scale());

    BigDecimal res = coerced_d.divide(t,BigDecimal.ROUND_HALF_UP);

    System.out.println("Result of division : " + res + " THIS IS UNEXPECTED!!!");

    res = res.multiply(new BigDecimal("100"));

    System.out.println("Final value : " + res);
  }
}