import java.util.Random;
public class Mines {

    public static final int BOARD_SIZE = 5;
    enum Space {
        Empty, Mine
    };

    public static void main(String[] args) {
        Random rand = new Random();

        // Creates board
        System.out.println("Empty board");
        Space[][] board = new Space[BOARD_SIZE][BOARD_SIZE];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                board[x][y] = Space.Empty;
                System.out.print("_");
            }
            System.out.println();
        }

        // Sets mines
        for (int i = 0; i < BOARD_SIZE; i++) {
            int mX = rand.nextInt(BOARD_SIZE);
            int mY = rand.nextInt(BOARD_SIZE);
            // Condition if random number combination [mX, mY] generated previously. Guarantees BOARD_SIZE mines always.
            if(Space.Mine.equals(board[mX][mY])) {
                i--;
                continue;
            }
            board[mX][mY] = Space.Mine;
        }

        System.out.println("\nPlacing mines");
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                switch (board[y][x]) {
                    case Empty :
                        System.out.print("_");
                        break;
                    case Mine :
                        System.out.print("*");
                        break;
                }
            }
            System.out.println();
        }

        // Count mines
        System.out.println("\nCounting mines");
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if(Space.Mine.equals(board[y][x])) {
                    System.out.print("*");
                } else {
                    System.out.print(findAdjCount(y, x, board));
                }
            }
            System.out.println();
        }
    }

    private static int findAdjCount(int row, int col, Space[][] board) {
        int cnt = 0;
        // Check 8 adjacent positions
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if(i >= 0 && i < BOARD_SIZE && j >= 0 && j < BOARD_SIZE) {
                    if(Space.Mine.equals(board[i][j])) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}