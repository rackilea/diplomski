public static List<String> getStringsInBrackets(String s) {
  Pattern p = Pattern.compile("\\[(.*?)\\]");
  Matcher m = p.matcher(s);
  List<String> list = new ArrayList<String>();
  while (m.find()) { list.add(m.group(1)); }
  return list;
}