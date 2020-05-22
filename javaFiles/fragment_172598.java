TokenStream tokenStream = analyzer.tokenStream(fieldName, reader);
OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);

tokenStream.reset();
while (tokenStream.incrementToken()) {
    int startOffset = offsetAttribute.startOffset();
    int endOffset = offsetAttribute.endOffset();
    String term = charTermAttribute.toString();
}