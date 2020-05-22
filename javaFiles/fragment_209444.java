public static String getSentence(String input, String word) {
    Matcher matcher = Pattern.compile(word, Pattern.LITERAL | Pattern.CASE_INSENSITIVE)
                             .matcher(input);
    if(matcher.find()) {
        BreakIterator br = BreakIterator.getSentenceInstance(Locale.ENGLISH);
        br.setText(input);
        int start = br.preceding(matcher.start());
        int end = br.following(matcher.end());
        return input.substring(start, end);
    }
    return null;
}