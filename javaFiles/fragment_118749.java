BigDecimal b1 = new BigDecimal("3.1");
BigDecimal b2 = new BigDecimal("3.10");
System.out.println(b1.doubleValue());
System.out.println(b2.doubleValue());
System.out.println(b1.scale());
System.out.println(b2.scale());
System.out.println(b1.equals(b2));
System.out.println(b1.hashCode());
System.out.println(b2.hashCode());