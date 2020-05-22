import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Board {
    private final int[] squares;

    public Board() {
    this.squares = new int[9];
    }

    protected Board(int[] squares) {
    this.squares = squares;
    }

    public void init() {
    Random rnd = new Random();
    int turn = 1; // 'O' always goes first.

        for (int i=0; i<squares.length; ++i) {
        double d = rnd.nextDouble();

        if (d < 0.75) {
        squares[i] = turn;
        turn = turn == 1 ? -1 : 1; // Flip to other player's turn.
        } else {
        squares[i] = 0; // Empty square.
        }

        if (isTerminalState()) {
        break;
        }
    }
    }

    public boolean isTerminalState() {
    boolean ret = false;

    boolean foundEmpty = false;
    int hSum = 0;
    int[] vSum = new int[3];

    for (int i=0; i<squares.length; ++i) {
        hSum += squares[i];

        if (isWinningRow(hSum)) {
        ret = true;
        break;
        } else if (i == 2 || i == 5) {
        hSum = 0;
        }

        int col = i % 3;
        vSum[col] += squares[i];

        if (isWinningRow(vSum[col])) {
        ret = true;
        break;
        }

        if (squares[i] == 0) {
        foundEmpty = true;
        }
    }

    if (!ret) {
        if (!foundEmpty) {
        ret = true;
        } else {
        int diag1 = 0;
        int diag2 = 0;
        int rowSz = (int)Math.sqrt(squares.length);

        for (int i=0; i<squares.length; ++i) {
            if (i % (rowSz + 1) == 0) {
            diag1 += squares[i];

            if (isWinningRow(diag1)) {
                ret = true;
                break;
            }
            }

            if (i > 0 && i % (rowSz - 1) == 0) {
            diag2 += squares[i];

            if (isWinningRow(diag2)) {
                ret = true;
                break;
            }
            }
        }
        }
    }

    return ret;
    }

    private boolean isWinningRow(int rowSum) {
    return rowSum == 3 || rowSum == -3;
    }

    public List<Board> getNextStates() {
    List<Board> ret = new LinkedList<Board>();

    int tmp = 0;
    for (int i=0; i<squares.length; ++i) {
        tmp += squares[i];
    }

    // Next turn is 'O' (i.e. +1) if the board sums to 0.
    // Otherwise it's 'X's turn.
    int turn = tmp == 0 ? 1 : -1;

    if (!isTerminalState()) {
        for (int i=0; i<squares.length; ++i) {
        if (squares[i] == 0) { // Empty square          
            int[] squaresA = new int[squares.length];
            System.arraycopy(squares, 0, squaresA, 0, squares.length);
            squaresA[i] = turn;
            ret.add(new Board(squaresA));
        }
        }
    }

    return ret;
    }

    public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i=0; i<squares.length; ++i) {
        if (squares[i] == 1) {
        sb.append('O');
        } else if (squares[i] == -1) {
        sb.append('X');
        } else {
        assert squares[i] == 0;
        sb.append('-');
        }

        if (i == 2 || i == 5) {
        sb.append('\n');
        }
    }

    return sb.toString();
    }

    public static void main(String[] args) {
    System.err.println("Creating board:\n");
    Board bd = new Board();
    System.err.println(bd);

    System.err.println("\nInitialising board:\n");
    bd.init();
    System.err.println(bd);
    System.err.println("Terminal state: " + bd.isTerminalState() + '\n');

    System.err.println("\nGenerating next move states:\n");
    List<Board> nextStates = bd.getNextStates();

    for (Board bd1 : nextStates) {
        System.err.println(bd1.toString() + '\n');
    }
    }
}