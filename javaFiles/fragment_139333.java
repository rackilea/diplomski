Pattern p = Pattern.compile("\\d+");
Matcher m = p.matcher(rtString);
if (m.find()) {
  List l_operators = Arrays.asList(p.split(rtString.substring(m.end()).trim()));
  // ...
}