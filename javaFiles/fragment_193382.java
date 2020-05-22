// Multiplication of unparenthesized integers
Pattern p = Pattern.compile("(\\d+)\\s*\\*\\s*(\\d+)");
Matcher m = p.matcher(s);
while (m.find()) {
  int a = Integer.parseInt(m.group(1));
  int b = Integer.parseInt(m.group(2));
  s = s.substring(0, m.start(1)) + (a*b) + s.substring(m.end(2));
  m.reset(s);
}