Calendar cal = Calendar.getInstance();

cal.set(0, Calendar.JANUARY, 1);
Date d1 = cal.getTime();

cal.set(9999, Calendar.DECEMBER, 31);
Date d2 = cal.getTime();

System.out.println(d1);
System.out.println(d2);