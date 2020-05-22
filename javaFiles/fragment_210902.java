private static Pattern p =
  Pattern.compile("ABC=([^ ]+) Temp=([^ ]+) Try=([^ ]+) Message=\"(.+)\" SYS=([^ ]+)");

private static MyData makeData(String input) {
  int abc = 0, temp = 0, tryNumber = 0, sys = 0;
  String message = "";

  Matcher m = p.matcher(input);
  if (!(m.find()) return null;
  abc = Integer.parseInt(m.group(1));
  temp = Integer.parseInt(m.group(2));
  tryNumber = Integer.parseInt(m.group(3));
  message = m.group(4);
  sys = Integer.parseInt(m.group(5));

  return new MyData(abc, temp, tryNumber, message, sys);
}