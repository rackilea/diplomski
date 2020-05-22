import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class CrossAndZeros {
    private static CellState winner;
    private static Enum[][] field = new Enum[3][3];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = CellState.values()[new Random().nextInt(3)];
            }
        }

        for (Enum[] enums : field) {
            System.out.println(Arrays.toString(enums));
        }
        System.out.println();

        System.out.println("Winner is found: " + isWinnerFound());

        System.out.println(winner == null ? "No winner, GAME OVER" : winner);
    }

    private static boolean isWinnerFound() {
        int[] result = calculate();
        int count = 0;

        for (int win : result) {
            if (win == 3) {
                winner = CellState.OCCUPIED_BY_X;
                return true;
            } else if (win == -12) {
                winner = CellState.OCCUPIED_BY_O;
                return true;
            } else if (win == -9 || win == -2 || win == -3) { // This means that the line is spoilt
                count++;
            }
        }
        return count == 8; // If all the lines are spoilt, the game is over
    }

    private static int[] calculate() {
        int[] result = new int[8];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
            result[i] += getCellOwner(field[j][i]); // a column
            result[i + 3] += getCellOwner(field[i][j]); // a row
        }
        result[field.length * 2] += getCellOwner(field[i][i]); // diagonal
        result[field.length * 2 + 1] += getCellOwner(field[i][field.length - i - 1]); // diagonal

        }

        System.out.println(Arrays.toString(result));

        return result;
    }

    private static int getCellOwner(Enum cell) {
        switch ((CellState) cell) {
            case OCCUPIED_BY_O:
                return -4;
            case OCCUPIED_BY_X:
                return 1;
            case EMPTY:
            default:
                return 0;
        }
    }

    public enum CellState {
        /**
         * this cell is occupied by player X
         */
        OCCUPIED_BY_X,

        /**
         * this cell is occupied by player O
         */
        OCCUPIED_BY_O,

        /**
         * this cell is Empty
         */
        EMPTY
    }
}