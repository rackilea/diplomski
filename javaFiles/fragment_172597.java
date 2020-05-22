TokenStream tokenStream = analyzer.tokenStream(fieldName, reader);
OffsetAttribute offsetAttribute = tokenStream.getAttribute(OffsetAttribute.class);
TermAttribute termAttribute = tokenStream.getAttribute(TermAttribute.class);

while (tokenStream.incrementToken()) {
    int startOffset = offsetAttribute.startOffset();
    int endOffset = offsetAttribute.endOffset();
    String term = termAttribute.term();
}