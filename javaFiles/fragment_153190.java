private static final Pattern FIND_WORDS_PATTERN =
        Pattern.compile("/[^/]+/|\\S+", Pattern.UNICODE_CHARACTER_CLASS);

public static List<String> getEachWord(String givenString) {
    List<String> words = new ArrayList<>();
    Matcher m = FIND_WORDS_PATTERN.matcher(givenString);
    while (m.find()) {
        words.add(m.group());
    }
    return words;
}