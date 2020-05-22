char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
String str = new String(chars, 1, 2);
System.out.println(str);   // Prints bc  

char[] chars2 = new char[]{'b', 'c'};
String str2 = new String(chars2, 0, 2);
System.out.println(str2);   // Prints bc

System.out.println(str.equals(str2));  // Prints true