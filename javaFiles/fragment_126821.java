String a = new String("A");
String b = new String("A");
String c = "A";
String d = "A";

System.out.println("a:" + a.hashCode() + " = b:" + b.hashCode() + " == " + (a == b));
System.out.println("b:" + b.hashCode() + " = c:" + c.hashCode() + " == " + (b == c));
System.out.println("c:" + c.hashCode() + " = d:" + d.hashCode() + " == " + (c == d));