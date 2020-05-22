int paramIndex = 0;

String text = "The {title} is {number} points.";
String paramRegex = "\\{(.*?)\\}";
Pattern paramPattern = Pattern.compile(paramRegex);
Matcher matcher = paramPattern.matcher(text);

while(matcher.find())
    text = text.replace(matcher.group(), "{" + paramIndex++ + "}");

text = MessageFormat.format(text, "kick", "3");