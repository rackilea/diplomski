double d = 60 / 1.1 * 1.1;
System.out.println("double without rounding: " + d);
System.out.printf("double With rounding %.2f%n", d);

BigDecimal bd = BigDecimal.valueOf(60).divide(BigDecimal.valueOf(1.1), 9, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(1.1));
System.out.println("BigDecimal without rounding: " + bd);
System.out.printf("BigDecimal with rounding %.2f%n", bd);
// or
bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
System.out.println("BigDecimal with rounding: " + bd);