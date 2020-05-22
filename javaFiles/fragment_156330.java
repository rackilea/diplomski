Pattern singleLinecommentsPattern = Pattern.compile("\\/\\/.*");
Matcher matcher = singleLinecommentsPattern.matcher(content);

while (matcher.find()) {
    document.setCharacterAttributes(matcher.start(), 
      matcher.end() - matcher.start(), textPane.getStyle("red"), true);
}

Pattern multipleLinecommentsPattern = Pattern.compile("\\/\\*.*?\\*\\/",
                        Pattern.DOTALL);
matcher = multipleLinecommentsPattern.matcher(content);

while (matcher.find()) {
    document.setCharacterAttributes(matcher.start(), 
      matcher.end() - matcher.start(), textPane.getStyle("red"), true);
}