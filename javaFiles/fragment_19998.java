public void test() {
    double d = 0.29;
    System.out.println("d=" + d);
    System.out.println("floor(d*100)/100=" + Math.floor(d * 100) / 100);
    System.out.println("BigDecimal d=" + BigDecimal.valueOf(d).movePointRight(2).round(MathContext.UNLIMITED).movePointLeft(2));
}