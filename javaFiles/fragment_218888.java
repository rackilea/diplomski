Pattern p = Pattern.compile("(sin|cos|tan)|(\\d+)");
Matcher m = p.matcher("cos60");
ArrayList<String> a = new ArrayList<>();
while (m.find())
    a.add(m.group(0));

System.out.println(a.toString());