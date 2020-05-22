Long bigLong = 1L<<51; //picked 51: 52 and 53 already causing rounding issues.
Long long1 = bigLong + 1L;
Long long2 = bigLong + 2L;
System.out.println(long1+" -> " + long1.doubleValue());
System.out.println(long2+" -> " + long2.doubleValue());

//false, enough precision to preserve bit "0" and "1".
System.out.println(long1.doubleValue()==long2.doubleValue());