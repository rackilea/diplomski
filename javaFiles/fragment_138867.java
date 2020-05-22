public String removeStopWords(){
    StandardAnalyzer analyser = new StandardAnalyzer();
    Analyzer analyzer = new StopAnalyzer();
    Tokenizer tokenizer = new StandardTokenizer();
    tokenizer.setReader(new StringReader(GetTweets.tweetContent));
    TokenStream tokenStream = tokenizer;
    StringBuilder sb = new StringBuilder();
    tokenStream = new StopFilter(tokenStream, StandardAnalyzer.STOP_WORDS_SET);
    CharTermAttribute token = tokenStream.getAttribute(CharTermAttribute.class);