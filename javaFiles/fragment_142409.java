String a = "Stackoverflow";
String b = "Stackoverflow";

String x = new String(a);
String y = new String(a);

System.out.println(a == b); // true due to constant pooling
System.out.println(x == y); // false; different objects