public class Hangman {

    private String word;
    private char[] blank;
    private int guesses;

    public Hangman() {
        word = "Toyota";
        blank = new char [word.length()];
        for (int i =0; i < word.length(); i++){
            blank[i] = '*';
        } 
        guesses = 0;
    }

    // Optional Constructor - Hangman hangman = new Hangman("Toyota");
    public Hangman(String word) {
        this.word = word;
        blank = new char [word.length()];
        for (int i =0; i < word.length(); i++){
            blank[i] = '*';
        } 
        guesses = 0;
    }

    /**
    * Rest of your code
    */
}