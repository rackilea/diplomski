String s1 = "1";
String s2 = "1";
System.out.println(s1 == s2); // true  => same reference, s1 & s2 point to the same object

String s3 = "1";
String s4 = new String("1");
System.out.println(s3 == s4); // false => s3 & s4 point to different objects