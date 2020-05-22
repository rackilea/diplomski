public final class LuceneUtils {

    public static List<String> parseKeywords(Analyzer analyzer, String field, String keywords) {

        List<String> result = new ArrayList<String>();
        TokenStream stream  = analyzer.tokenStream(field, new StringReader(keywords));

        try {
            while(stream.incrementToken()) {
                result.add(stream.getAttribute(TermAttribute.class).term());
            }
        }
        catch(IOException e) {
            // not thrown b/c we're using a string reader...
        }

        return result;
    }  
}