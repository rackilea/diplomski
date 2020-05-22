String str1 = "bla";
// Use String::new to make sure 'str1' and 'str2' don't reference the same literal
String str2 = new String("bla");

System.out.println(str1 == str1); // true
System.out.println(str1 == str2); // false
System.out.println(str1.equals(str2)); // true