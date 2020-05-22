URL url = new URL("http://stackoverflow.com/");
URLConnection connection = url.openConnection();
BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
StringBuilder stringBuilder = new StringBuilder();
String inputLine;
while ((inputLine = reader.readLine()) != null) {
    stringBuilder.append(inputLine);
}
String pageContent = stringBuilder.toString();
Pattern pattern = Pattern.compile("<(?!!)(?!/)\\s*([a-zA-Z0-9]+)(.*?)>");
Matcher matcher = pattern.matcher(pageContent);
while (matcher.find()) {
    String tagName = matcher.group(1);
    String attributes = matcher.group(2);
    System.out.println("tag name: " + tagName);
    System.out.println("     rest of the tag: " + attributes);
    Pattern attributePattern = Pattern.compile("(\\S+)=['\"]{1}([^>]*?)['\"]{1}");
    Matcher attributeMatcher = attributePattern.matcher(attributes);
    while(attributeMatcher.find()) {
        String attributeName = attributeMatcher.group(1);
        String attributeValue = attributeMatcher.group(2);
        System.out.println("         attribute name: " + attributeName + "    value: " + attributeValue);
    }
}