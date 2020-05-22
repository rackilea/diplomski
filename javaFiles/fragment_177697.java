public class Game {

    String secretWord, correctGuess, hiddenWord;

    //Lives remaining by player
    int livesRemaining;

    public int maxLetters;

    public Game(int lives) {
        secretWord = "";
        correctGuess = "";
        hiddenWord = "";
        livesRemaining = lives;
    }
}