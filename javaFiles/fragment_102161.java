Long bigLong = 1L<<54;
Long long1 = bigLong + 1L;
Long long2 = bigLong + 2L;
System.out.println(long1+" -> " + long1.doubleValue());
System.out.println(long2+" -> " + long2.doubleValue());
System.out.println(long1.doubleValue()==long2.doubleValue());