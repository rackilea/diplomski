public class BetterWord extends AbstractWord 
        implements WordLengthSupport {
    WordLength wordLength;
    public WordLength getWordLength() {
        if(wordLength==null) {
            // each time word changes 
            // make sure to set wordLength to null
            calculateWordLength(); 
        }
        return wordLength;
    }
    private void calculateWordLength() {
        // This method should be 
        //    called in constructor 
        //    or each time word changes 
        int length = // based on the variable word calculate Length..
        this.wordLength = new WordLength();
        this.wordLength.setLength(length);
    }
}