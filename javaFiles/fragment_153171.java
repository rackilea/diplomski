public class StartsWithCapitalTokenFilter extends FilteringTokenFilter {

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);

    public StartsWithCapitalTokenFilter(TokenStream tokenStream) {
        super(tokenStream);
    }

    @Override
    public boolean accept() {
        // When accept() is called, my understanding is that termAtt.buffer() will
        // contain the particular string (in char[] form) of whichever token
        // is under consideration. This call gets the Unicode code point of the
        // first character and checks if it's uppercase.
        return Character.isUpperCase(Character.codePointAt(termAtt.buffer(),0));

        // Or if you don't want to care about Unicode about U+FFFF, use the below.
        //return Character.isUpperCase(termAtt.buffer()[0]);
    }
}