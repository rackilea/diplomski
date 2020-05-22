public class Board {
    private String[][] board = new String[7][7];
    ...
    public void set(int i, int j, String value) {
        if(isInBounds(i, j) && isAboveEmpty(i, j) && isBelowEmpty(i, j) && isBeforeEmpty(i, j) && isAfterEmpty(i, j)) {
            board[i,j] = value;
        }
    }
}