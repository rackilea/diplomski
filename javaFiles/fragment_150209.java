String pattern = "\\[(-?\\d+),(-?\\d+)\\]";
Pattern regex = Pattern.compile(pattern);
Matcher regexMatcher = regex.matcher(line);
while (regexMatcher.find()){
    int i = Integer.valueOf(regexMatcher.group(1));
    int j = Integer.valueOf(regexMatcher.group(2));
    ...
}