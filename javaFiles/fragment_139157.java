String s1 = "Abe peter said pan saw his lying expression";
String s2 = "Apple";
String s3 = "APPLE";
System.out.println(s1.matches("(?i)a.*?p.*?p.*?l.*?e\\S*"));
System.out.println(s2.matches("(?i)a.*?p.*?p.*?l.*?e\\S*"));
System.out.println(s3.matches("(?i)a.*?p.*?p.*?l.*?e\\S*"));