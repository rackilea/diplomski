Pattern pattern = Pattern.compile("'.*?'|\".*?\"|\\s*\\b(AND|OR)\\b\\s*", Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(input);
int nextPartPos = 0;
while (matcher.find()) {
    if (matcher.group(1) != null) {
        System.out.println(input.substring(nextPartPos, matcher.start()));
        nextPartPos = matcher.end();
        System.out.println("--> " + matcher.group(1) + " <--");
    }
}
if (nextPartPos < input.length()) {
    System.out.print(input.substring(nextPartPos));
}