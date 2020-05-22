public class MyTokenFilterFactory extends AbstractTokenFilterFactory {

    public MyTokenFilterFactory(IndexSettings indexSettings, Environment environment,
                                String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new TokenFilter(tokenStream);
    }
}