BigDecimal d1 = BigDecimal.valueOf(90.000000000000001d);
BigDecimal d2 = BigDecimal.valueOf(90.000000000000002d);
System.out.println(d1.equals(d2));

BigDecimal s1 = new BigDecimal("90.000000000000001");
BigDecimal s2 = new BigDecimal("90.000000000000002");
System.out.println(s1.equals(s2));