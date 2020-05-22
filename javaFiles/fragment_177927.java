BigDecimal num = new BigDecimal(Long.MAX_VALUE);
System.out.println(num);                  // prints: 9223372036854775807
System.out.println(num.longValue());      // prints: 9223372036854775807

num = num.add(BigDecimal.TEN);            // num is now too large for long
System.out.println(num);                  // prints: 9223372036854775817
System.out.println(num.longValue());      // prints: -9223372036854775799
System.out.println(num.longValueExact()); // throws: ArithmeticException: Overflow