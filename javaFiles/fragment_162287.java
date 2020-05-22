Pattern Regex = Pattern
            .compile(
                    "(?:(\\d+) ?(days?|d) *?)?(?:(\\d+) ?(hours?|h) *?)?(?:(\\d+) ?(minutes?|m) *?)?(?:(\\d+) ?(seconds?|s))?",
                    Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE
                            | Pattern.UNICODE_CASE);
    Matcher RegexMatcher = Regex.matcher("1 d 3 hours");
    while (RegexMatcher.find()) {
        System.out.println(RegexMatcher.group());
    }