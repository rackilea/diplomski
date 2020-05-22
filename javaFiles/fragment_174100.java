// String input = "Drop 3:6-9";
Pattern pattern = Pattern.compile("(\\S+)\\s+(\\d+):(\\d+)-(\\d+)");
Matcher matcher = pattern.matcher(input);
if (matcher.find())
    String name = matcher.group(1); // "Drop"
    String number = matcher.group(2); // "3"
    String betweenStart = matcher.group(3); // "6"
    String betweenEnd = matcher.group(4); // "9"
}
// else: invalid input, error handling left as an exercise for the reader