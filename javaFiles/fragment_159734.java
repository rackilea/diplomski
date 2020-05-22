private static final Pattern TOTAL_STRING_PATTERN =
    Pattern.compile("^(\\d+:\"([^\"\\\\]|\\\\.)*\"(,(?!$)|$))+$");
private static final Pattern PARTIAL_STRING_PATTERN =
    Pattern.compile("(\\d+):\"((?:[^\"\\\\]|\\\\.)*)\"");

public Map<Integer, String> parse(final String input) {
    if(! TOTAL_STRING_PATTERN.matcher(input).matches()) {
        throw new IllegalArgumentException();
    }
    final Map<Integer, String> ret = new HashMap<Integer, String>();
    final Matcher m = PARTIAL_STRING_PATTERN.matcher(input);
    while(m.find()) {
        final Integer id = Integer.valueOf(m.group(1));
        final String description = StringEscapeUtils.unescapeJava(m.group(2));
        ret.put(id, description);
    }
    return Collections.unmodifiableMap(ret);
}