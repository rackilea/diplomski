String longString = "Amal Kamal Jamal Amitha Farook Amani Tom Adele George Ariana";
String pattern = "(?i)(?<!\\S)a[a-z]{4,}(?!\\S)";
Pattern checkRegex = Pattern.compile(pattern);
Matcher regexMatcher = checkRegex.matcher(longString);
while (regexMatcher.find()) {
    System.out.println(regexMatcher.start() + " : " + regexMatcher.group());
}