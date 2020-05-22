String span = "some text, param1:'1123',some text, param2:'3444';";
Pattern p = Pattern.compile(Pattern.quote("'") + "(.*?)" + Pattern.quote("'"));
Matcher m = p.matcher(span);
while (m.find()) {
  System.out.println(m.group(1));
}