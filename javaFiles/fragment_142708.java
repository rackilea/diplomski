String xmlString = "<int name=\"count\" value=\"10\" />";
int newValue = 100;
Pattern pattern = Pattern.compile("(<int name=\"count\" value=\")([0-9]{0,})(\" />)");
Matcher matcher = pattern.matcher(xmlString);

while (matcher.find()) {
    String match = matcher.group(2);
    xmlString = xmlString.replace(match, String.valueOf(newValue));
}

System.out.println(xmlString);