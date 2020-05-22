private static final Pattern PUNCTUATION_PATTERN = Pattern.compile("[.?!]$");

static String stemWord(Stemmer s, String word) throws Exception {
    String word = "testing.";
    String stem = s.StemWordWithWordNet(word);

    Matcher m = PUNCTUATION_PATTERN.matcher(word);
    String endingPunctuation = m.find() ? m.group() : "";

    return stem + endingPunctuation;
}