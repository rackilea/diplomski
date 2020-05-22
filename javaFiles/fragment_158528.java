public <T> void addParser(final Parser<T> parser) {
    parsers.put(parser.getType(), parser);
}

private <T> Parser<T> parserFor(final Class<T> type) {
    return parsers.get(type).castToParserOf(type);
}