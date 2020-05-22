String s = "[Tom] The rest of the title";
String v = "Tom";

String myRegexp = String.format("(?i)\\[%s\\]|\\{%s\\}|\\(%s\\)|%s", v,v,v,v);
System.out.println(myRegexp);

s = s.replaceAll(myRegexp, "");
System.out.println(s);