// input string
String input = "Please remove my stop words!";

// tokenize the input string
TokenStream tokenStream = new ClassicTokenizer(Version.LUCENE_35, new StringReader(input));
// remove stop words
tokenStream = new StopFilter(Version.LUCENE_35, tokenStream, EnglishAnalyzer.getDefaultStopSet());

// retrieve the remaining tokens
Set<String> tokens = new HashSet<String>();
CharTermAttribute token = tokenStream.getAttribute(CharTermAttribute.class);
try {
    while (tokenStream.incrementToken()) {
        tokens.add(token.toString());
    }
} catch (IOException e) {
    // log
}

// tokens contains only non-stop words from now on