StringBuffer sb = new StringBuffer(); sb.append("a").append("b");
String a = new String(sb.toString());
String b = new String(sb.toString());
a == b; //false
a.equals(b); //true
a.intern() == b.intern(); //true