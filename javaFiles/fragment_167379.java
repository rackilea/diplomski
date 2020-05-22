final String regex = "\\$\\.test[^'\"]*(?:\"([^\"\\\\]*(?:\\\\.[^\"\\\\]*)*)\"|'((?:[^'\\\\]*(?:\\\\.[^'\\\\]*)*))').*";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher( input );

while (matcher.find()) {
    System.out.printf("Group-1: %s, Group-2: %s%n", matcher.group(1), matcher.group(2));
}