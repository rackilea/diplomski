String someJson ="{\"to\":\"broadcast\", \"type\":\"50\", \"payload\":[{\"name\":\"John Doe Jr.\"},{\"name2\":\"John Doe\"}]}";

Pattern p = Pattern.compile(".*?payload\":(.*)}");
Matcher m = p.matcher(someJson);
if (m.matches()) {
  String payload = m.group(1);
}