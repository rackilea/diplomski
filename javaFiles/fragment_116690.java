String s  = "Record with text1 Record with text2 Record with text3";
Pattern p = Pattern.compile("(?i)\\brecord(?:(?!record).)+");
Matcher m = p.matcher(s);
while (m.find()) {
  System.out.println(m.group());
}