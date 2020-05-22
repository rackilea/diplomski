java.util.Date d1 = java.sql.Date.valueOf("2012-01-01");
java.util.Date d2 = new java.util.Date(d1.getTime());
java.util.Date d3 = new java.sql.Timestamp(d1.getTime());

System.out.println(d1.equals(d2)); // true
System.out.println(d2.equals(d1)); // true
System.out.println(d1.equals(d3)); // true
System.out.println(d3.equals(d1)); // false
System.out.println(d2.equals(d3)); // true
System.out.println(d3.equals(d2)); // false