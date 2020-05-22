DecimalFormat df = new DecimalFormat("000.0", DecimalFormatSymbols.getInstance(Locale.US));
System.out.println(df.format(new BigDecimal("1")));       // prints: 001.0
System.out.println(df.format(new BigDecimal("11.1")));    // prints: 011.1
System.out.println(df.format(new BigDecimal("123.456"))); // prints: 123.5
System.out.println(df.format(new BigDecimal(".07")));     // prints: 000.1
System.out.println(df.format(new BigDecimal("123456")));  // prints: 123456.0