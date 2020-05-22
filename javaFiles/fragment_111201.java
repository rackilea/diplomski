Pattern p = Pattern.compile("<!--abc Start-->(.*?)<!--abc end-->", Pattern.DOTALL);
Matcher m = p.matcher(temp);

while(m.find()) {
  String betweenStartAndEnd = m.group(1);
  ...
}