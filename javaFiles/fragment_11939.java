static final String PATTERN_CHARS = "GyMdkHmsSEDFwWahKzZLc";

// ...

private void validatePatternCharacter(char format) {
    int index = PATTERN_CHARS.indexOf(format);
    if (index == -1) {
        throw new IllegalArgumentException("Unknown pattern character '"
            + format + "'");
    }
}