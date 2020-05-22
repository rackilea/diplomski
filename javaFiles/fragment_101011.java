BigDecimal d1 = new BigDecimal("100.00");
    BigDecimal d2 = new BigDecimal("0.1");
    for(int i = 0; i < 100; i++) {
        d1 = d1.subtract(d2);
        System.out.println(d1);
    }