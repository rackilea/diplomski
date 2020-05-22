String x = "xyz";
String y = "xyz";
System.out.println(x == y); // Guaranteed to print true

StringBuilder builder = new StringBuilder();
String z = builder.append("x").append("yz").toString();

System.out.printn(x == z); // Will print false