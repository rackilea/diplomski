public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TicTacToe tictac = new TicTacToe(scanner);
    tictac.askLetter();
    tictac.decide();
    // You might want to close the scanner here, but you don't really have to.
}