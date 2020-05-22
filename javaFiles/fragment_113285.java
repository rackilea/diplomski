byte[] chars = { 'h', 'e', 10, 15, 21, 'l', 'l', 'o', 13 };
String str = new String(chars, "utf8");
System.out.println("==========");
System.out.println(str);
System.out.println("==========");
System.out.println(str.replaceAll("[\\p{Cntrl}\\p{Cc}]", ""));
System.out.println("==========");