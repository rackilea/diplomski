Pattern p = Pattern.compile("(.*)(?<!\\\\)@(.*)");
Matcher matcher = p.matcher(string);
String[] parts = new String[2];
if (matcher.matches()) {
    parts[0] = matcher.group(1);
    parts[1] = matcher.group(2);
}