public class Test {
    public static void main(String[] args) throws Exception {
        MCBoard board = new MCBoard();
        MinimaxThread mmt = new MinimaxThread(board.clone(), 2, true);
    }
}