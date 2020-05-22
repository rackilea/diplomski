private String playerName = "";
private int numberOfPegs = 0;
private boolean gameRunning = "True";
private Display display;


public static void main(String[] args) {

    Game game = new Game();
    game.setupGame();
    game.playGame();
}

public void setupGame() {

    display = new Display();
    Code code = new Code();
    display.showGreeting();
    playerName = display.getUserInput("Enter your name: ");
    numberOfPegs = Integer.parseInt(display.getUserInput("How many pegs would you like?"));
    code.generateNewCode(numberOfPegs);
}

public void playGame() {
    String result = display.getGuess();

}