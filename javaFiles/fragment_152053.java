public static String removeSpaces(String input) {
    return input.replaceAll("\\s+", "");
}

String input = "abc test=\"x y z\" magic=\" hello \" hola";
Pattern p = Pattern.compile("\"(.*?)\"");
Matcher m = p.matcher(input);
StringBuffer sb = new StringBuffer("");
while (m.find()) {
    m.appendReplacement(sb, "\"" + removeSpaces(m.group(1)) + "\"");
}
m.appendTail(sb);

String[] parts = sb.toString().split("\\s+");
for (String part : parts) {
    System.out.println(part);
}

abc
test="xyz"
magic="hello"
hola