Pattern pattern = Pattern.compile("\\b(\\w+)(\\W+(?i:\\1)\\b)+");
Matcher matcher = pattern.matcher("Hello hello");
    while (matcher.find()) {
        int groupCount = matcher.groupCount(); // returns 0
        for (int i = 0; i <= groupCount; i++) {
            System.out.printf("%d. %s%n", i, matcher.group(i));
        }
    }