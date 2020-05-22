BigDecimal bd = BigDecimal.valueOf(1.555d);
System.out.println("bd=" + bd);
bd = bd.setScale(2, RoundingMode.HALF_UP);
System.out.println("after rounding bd=" + bd);
double d = bd.doubleValue();
System.out.println("after rounding d=" + d);