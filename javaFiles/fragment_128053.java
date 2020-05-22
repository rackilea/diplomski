public ParsedSentence parse(String sentence) throws NullPointerException {
    try {
        String parsedSentence = parser.parse(sentence);
        return new ParsedSentence(parsedSentence);
    }
    return null;
}