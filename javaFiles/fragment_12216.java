public static String stem(String string) throws IOException {
    TokenStream tokenizer = new StandardTokenizer(Version.LUCENE_47, new StringReader(string));
    tokenizer = new StandardFilter(Version.LUCENE_47, tokenizer);
    tokenizer = new LowerCaseFilter(Version.LUCENE_47, tokenizer);
    tokenizer = new PorterStemFilter(tokenizer);

    CharTermAttribute token = tokenizer.getAttribute(CharTermAttribute.class);

    tokenizer.reset();

    StringBuilder stringBuilder = new StringBuilder();

    while(tokenizer.incrementToken()) {
        if(stringBuilder.length() > 0 ) {
            stringBuilder.append(" ");
        }

        stringBuilder.append(token.toString());
    }

    tokenizer.end();
    tokenizer.close();

    return stringBuilder.toString();
}