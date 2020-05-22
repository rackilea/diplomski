public class Hangman {

    public static void main(String[] argv) {
        // Instantiate the class.
        hangManWords g = new hangManWords();

        // Call the methods...

        // g has access to `words` so no need for an argument.
        g.randomizeWords(); //randomly generates a word from the word list

        // g has access to `words` so no need for an argument.
        //players first word
        guessThisWord = g.getNextWord();

        // I don't see `hideWord` and `originalWord` defined, but assume they are somwehere.
        guessThisWord = g.hideWord(guessThisWord, originalWord); //hides the word with _
    }
}