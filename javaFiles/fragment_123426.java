public static void main(String[] args) {
    do {
        ScaredyCat game = new ScaredyCat(new Player("Urkel",23),new Player("Steve", 18));
        game.play();
    } while(playAgain());
}

private static boolean playAgain() {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Play again? (Y/N): ");
    String replay = keyboard.nextLine();
    return replay.equals("Y");
}