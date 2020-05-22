String s = "com.xxx.xxx.ClassName 0.0.2";
Pattern p = Pattern.compile("\\w+(?= )");
Matcher m = p.matcher(s);
while (m.find()) {
System.out.println(m.group(0));
}