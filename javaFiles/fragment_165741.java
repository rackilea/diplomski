public static List<Keyword> guessFromString(String input) throws IOException {

  TokenStream tokenStream = null;
  try {

    // hack to keep dashed words (e.g. "non-specific" rather than "non" and "specific")
    input = input.replaceAll("-+", "-0");
    // replace any punctuation char but apostrophes and dashes by a space
    input = input.replaceAll("[\\p{Punct}&&[^'-]]+", " ");
    // replace most common english contractions
    input = input.replaceAll("(?:'(?:[tdsm]|[vr]e|ll))+\\b", "");

    // tokenize input
    tokenStream = new ClassicTokenizer(Version.LUCENE_36, new StringReader(input));
    // to lowercase
    tokenStream = new LowerCaseFilter(Version.LUCENE_36, tokenStream);
    // remove dots from acronyms (and "'s" but already done manually above)
    tokenStream = new ClassicFilter(tokenStream);
    // convert any char to ASCII
    tokenStream = new ASCIIFoldingFilter(tokenStream);
    // remove english stop words
    tokenStream = new StopFilter(Version.LUCENE_36, tokenStream, EnglishAnalyzer.getDefaultStopSet());

    List<Keyword> keywords = new LinkedList<Keyword>();
    CharTermAttribute token = tokenStream.getAttribute(CharTermAttribute.class);
    tokenStream.reset();
    while (tokenStream.incrementToken()) {
      String term = token.toString();
      // stem each term
      String stem = stem(term);
      if (stem != null) {
        // create the keyword or get the existing one if any
        Keyword keyword = find(keywords, new Keyword(stem.replaceAll("-0", "-")));
        // add its corresponding initial token
        keyword.add(term.replaceAll("-0", "-"));
      }
    }

    // reverse sort by frequency
    Collections.sort(keywords);

    return keywords;

  } finally {
    if (tokenStream != null) {
      tokenStream.close();
    }
  }

}