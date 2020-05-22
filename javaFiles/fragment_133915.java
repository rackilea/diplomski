String s = "12131415";
Pattern p = Pattern.compile("(?<Hour>\\d{2})");
Matcher m = p.matcher(s);
while (m.find()) {
System.out.println(m.group(1));
}