public static Set<String> findNames(final String input) {
    final Matcher matcher = TWITTER_NAME.matcher(input);
    final Set<String> names = new HashSet<>();
    while (matcher.find()) {
        names.add(matcher.group());
    }
    return names;
}