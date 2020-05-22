Pattern pattern = Pattern.compile("\\w(?=(\\w))");
//                                       ^   ^
//                                       |   |
//                             Add a capturing group

Matcher matcher = pattern.matcher("abcde");

while (matcher.find()) {
    // Use the captured content of the lookahead below:
    System.out.println(matcher.group(0) + matcher.group(1));
}