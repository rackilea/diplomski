String pattern = "\\s*-\\s*";
String s1 = "abc- abc";
String s2 = "abc -abc";
String s3 = "abc - abc";
String s4 = "abc-abc";
System.out.println(s1.replaceAll(pattern, " - "));
System.out.println(s2.replaceAll(pattern, " - "));
System.out.println(s3.replaceAll(pattern, " - "));
System.out.println(s4.replaceAll(pattern, " - "));