public class CustomAnalyzer extends Analyzer {

    protected TokenStreamComponents createComponents(String s) {
        // provide your own tokenizer, that will split input string as you want it
        final Tokenizer standardTokenizer = new MyStandardTokenizer();

        TokenStream tok = new StandardFilter(standardTokenizer);
        // make everything lowercase, remove if not needed
        tok = new LowerCaseFilter(tok);
        //provide stopwords if you want them
        tok = new StopFilter(tok, stopwords);
        return new TokenStreamComponents(standardTokenizer, tok);
    }

    private class MyStandardTokenizer extends Tokenizer {

        public boolean incrementToken() throws IOException {
            //mimic the logic of standard analyzer and add your rules
            return false;
        }
    }
}