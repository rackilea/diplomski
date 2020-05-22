public static TemporalAmount parse(String feString) {
    if (Character.isUpperCase(feString.charAt(feString.length() - 1))) {
        return Period.parse("P" + feString);
    } else {
        return Duration.parse("PT" + feString);
    }
}