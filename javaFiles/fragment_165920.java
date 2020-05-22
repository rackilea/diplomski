Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
TokenStream tokenStream = analyzer.tokenStream("CONTENT", new StringReader("c/d e/f n/a"));
CharTermAttribute term = tokenStream.getAttribute(CharTermAttribute.class);
PositionIncrementAttribute position = tokenStream.getAttribute(PositionIncrementAttribute.class);
int pos = 0;
while (tokenStream.incrementToken()) {
    String termStr = term.toString();
    int incr = position.getPositionIncrement();
    if (incr == 0 ) {
        System.out.print(" [" + termStr + "]");
    } else {
        pos += incr;
        System.out.println(" " + pos + ": [" + termStr +"]");
    }
}