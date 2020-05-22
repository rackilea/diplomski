Pattern p = Pattern.compile("([0-9]+)\\s(to)\\s([0-9]+)");
Matcher m = p.matcher("1 to 5");
m.find();
System.out.println(m.group(1));
System.out.println(m.group(2));
System.out.println(m.group(3));