BigDecimal val1=new BigDecimal(3.1f);
BigDecimal val2=new BigDecimal(3.1);
System.out.println(val1.subtract(val2, MathContext.UNLIMITED).toEngineeringString()); //-95.367431729442841970012523233890533447265625E-9
System.out.println(val1.equals(val2)); //false
System.out.println(val1.compareTo(val2)); // -1
System.out.println(val1.precision()); // 22
System.out.println(val2.precision()); // 52