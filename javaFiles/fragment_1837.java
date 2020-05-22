String s1 = "/fr/welcome?param1=222&param2=aloa&language=en";
String s2 = "/fr/welcome?language=en";
String s3 = "/fr/welcome?param1=222&language=en&param2=aa";
String m1 = s1.replaceAll("[&?]language.*?(?=&|\\?|$)", "");
String m2 = s2.replaceAll("[&?]language.*?(?=&|\\?|$)", "");
String m3 = s3.replaceAll("[&?]language.*?(?=&|\\?|$)", "");
System.out.println(m1);
System.out.println(m2);
System.out.println(m3);