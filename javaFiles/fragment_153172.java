public class StartswithCapitalAnalyzer extends Analyzer {
    @Override
    protected TokenStreamComponents createComponents(String field, Reader reader) {
        Tokenizer tokenizer = new StandardTokenizer();
        TokenStream filter = new StartsWithCapitalTokenFilter(tokenizer);

        // chain any other filters you want in here, like so:
        //filter = new LowerCaseFilter(filter);

        return new TokenStreamComponents(tokenizer, filter);
    }
}