String data = "This is\\u2019 a sample text file \\u2014and it can ...";
Pattern p = Pattern.compile("\\\\u(\\p{XDigit}{4})");
Matcher m = p.matcher(data);
StringBuffer buf = new StringBuffer(data.length());
while (m.find()) {
  String ch = String.valueOf((char) Integer.parseInt(m.group(1), 16));
  m.appendReplacement(buf, Matcher.quoteReplacement(ch));
}
m.appendTail(buf);
System.out.println(buf);