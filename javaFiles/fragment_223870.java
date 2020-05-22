int start = 0;
while (start < s.length() && !Character.isDigit(s.charAt(start))) {
  ++start;
}
int end = start;
while (end < s.length() && Character.isDigit(s.charAt(end))) {
  ++end;
}
String digits = s.substring(start, end);