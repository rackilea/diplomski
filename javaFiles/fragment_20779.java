public static String extractIP(String s) {
    java.util.regex.Matcher m = java.util.regex.Pattern.compile(
        "(?<!\\d|\\d\\.)" +
        "(?:[01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "(?:[01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "(?:[01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "(?:[01]?\\d\\d?|2[0-4]\\d|25[0-5])" +
        "(?!\\d|\\.\\d)").matcher(s);
    return m.find() ? m.group() : null;
}