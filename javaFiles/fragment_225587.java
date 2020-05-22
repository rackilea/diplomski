public class runGame {
    public static void main(String[]args) {
        Hangman game = new Hangman();
        System.out.println(game.getWord());
        System.out.println(game.getWordSoFar());
        game.Guess();
    }
}