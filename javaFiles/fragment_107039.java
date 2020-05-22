Pattern p1 = Pattern.compile("(a)\\1*");
Pattern p2 = Pattern.compile("(a)");

Matcher m1 = p1.matcher("aa");
Matcher m2 = p2.matcher("aa");

m1.find();
System.out.println(m1.group());
m2.find();
System.out.println(m2.group());