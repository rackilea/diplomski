public class TextChess {
    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'♜', '♞', '♝', '♛', '♚', '♝', '♞', '♜'},
            {'♟', '♟', '♟', '♟', '♟', '♟', '♟', '♟'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'♙', '♙', '♙', '♙', '♙', '♙', '♙', '♙'},
            {'♖', '♘', '♗', '♕', '♔', '♗', '♘', '♖'}
        };

        for (int i = 0; i < board.length; i++) {
            char[] pieces = board[i];
            System.out.print("" + (8 - i) + " ");
            for (char piece : pieces) {
                System.out.print(piece + " "); // you're missing this space
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}