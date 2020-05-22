public static void main(String... args) {
    char[][] arr = {
            { '+', '+', '+', '+', '+' },
            { '+', 'C', '-', '-', '+' },
            { '+', '+', '+', '-', '+' },
            { '-', '-', '-', '+', '+' },
    };

    System.out.println(new CountMovableSteps(arr).getAsInt()); // 3
}

public final class CountMovableSteps implements IntSupplier {
    private final char[][] board;
    private int x = -1;
    private int y = -1;

    public CountMovableSteps(char[][] board) {
        this.board = new char[board.length][];

        for (int row = 0; row < board.length; row++) {
            this.board[row] = new char[board[row].length];

            for (int col = 0; col < board[row].length; col++) {
                this.board[row][col] = board[row][col];

                if (board[row][col] == 'C') {
                    x = col;
                    y = row;
                }
            }
        }
    }

    @Override
    public int getAsInt() {
        return dfs(0, x, y);
    }

    private int dfs(int count, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length)
            return count;
        if (board[row][col] == '+' || board[row][col] == '*')
            return count;

        if (board[row][col] != 'C')
            count++;

        board[row][col] = '*';
        count = dfs(count, row, col + 1);
        count = dfs(count, row, col - 1);
        count = dfs(count, row + 1, col);
        count = dfs(count, row - 1, col);

        return count;
    }
}