BigDecimal add = new BigDecimal("1.00")
              .divide(BigDecimal.valueOf(3), 2, BigDecimal.ROUND_HALF_UP)
              .multiply(BigDecimal.valueOf(3)).add(new BigDecimal("0.01"));
    System.out.println(add);
    double add2 = 1.0 / 3 * 3 +  0.01;
    System.out.println(add2);