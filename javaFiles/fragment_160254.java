// function to do index search by source
  private static TopDocs searchBySource(String source, IndexSearcher searcher) throws Exception {
    // phrase query build
    PhraseQuery.Builder builder = new PhraseQuery.Builder();
    TokenStream tokenStream = new StandardAnalyzer().tokenStream("source", source);
    tokenStream.reset();
    while (tokenStream.incrementToken()) {
      CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
      builder.add(new Term("source", charTermAttribute.toString()));
    }
    tokenStream.end();
    tokenStream.close();
    builder.setSlop(2);
    PhraseQuery query = builder.build();
    System.out.println(query);
    // phrase search
    TopDocs hits = searcher.search(query, 10);
    return hits;
  }