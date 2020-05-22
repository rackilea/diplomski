final String in = "šđčćasdf";
final StringBuilder out = new StringBuilder();
for (int i = 0; i < in.length(); i++) {
  final char ch = in.charAt(i);
  if (ch <= 127) out.append(ch);
  else out.append("\\u").append(String.format("%04x", (int)ch));
}
System.out.println(out.toString());