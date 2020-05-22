/**
 * Parse the given pattern expression.
 */
private void parse(String expression) throws IllegalArgumentException {
    String[] fields = StringUtils.tokenizeToStringArray(expression, " ");
    if (fields.length != 6) {
        throw new IllegalArgumentException(String.format(""
                + "cron expression must consist of 6 fields (found %d in %s)", fields.length, expression));
    }