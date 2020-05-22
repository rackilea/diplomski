String sql = "INSERT INTO employees VALUES (\"John Doe\", \"45\", \"engineer\");";
final Pattern patter = Pattern.compile("INSERT INTO employees VALUES (\"(.*?)\", \"(.*?)\", \"(.*?)\");");
final Matcher matcher = pattern.matcher(sql);
if (matcher.matches()) {
  String name = matcher.group(1);
  String age = matcher.group(2);
  String job = matcher.group(3);
  // do stuff ...
}