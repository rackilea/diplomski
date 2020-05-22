public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to classic guessing game of high/low!");
    int guesses = 0;
    String difficulty = scan.next();

    if (difficulty.equals("easy")) {
        guesses = playGame(10);
    } else if (difficulty.equals("medium")) {
        guesses = playGame(100);
    } else if (difficulty.equals("hard")) {
        guesses = playGame(1000);
    }