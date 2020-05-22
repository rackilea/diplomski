String regex = "\\{\\\"\\$ref\\\":\\\"(\\d{1,})*\\\"\\}";
Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);

Matcher matcher = pattern.matcher(jsonString);
String resultString="";
if (matcher.find())
{
    resultString = matcher.replaceAll("$1");
}