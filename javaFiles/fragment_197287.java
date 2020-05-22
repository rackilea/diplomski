BigDecimal bd = BigDecimal.valueOf(0.15);
System.out.println("bd=" + bd);
System.out.println(df.format(bd)); // expecting 0.1, getting 0.1
bd = BigDecimal.valueOf(0.05);
System.out.println("bd=" + bd);
System.out.println(df.format(bd));
bd = BigDecimal.valueOf(0.06);
System.out.println("bd=" + bd);
System.out.println(df.format(bd));