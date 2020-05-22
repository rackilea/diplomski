public static BigDecimal increaseBy1(BigDecimal value) {
    int scale = value.scale();
    return value.add(BigDecimal.ONE.scaleByPowerOfTen(-scale));
}

public static void main(String[] args) {
    System.out.println(increaseBy1(new BigDecimal("100.012")));
    System.out.println(increaseBy1(new BigDecimal("100.01")));
    System.out.println(increaseBy1(new BigDecimal("100.1")));
    System.out.println(increaseBy1(new BigDecimal("100")));
}