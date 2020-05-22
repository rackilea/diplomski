public class Test2 {
    static char arry[][] = { { '#', '#', '#' }, { '#', ' ', ' ' },
            { '#', ' ', '#' }, { '#', ' ', '1' }, };
    static boolean[][] visited = new boolean[arry.length][arry[0].length];

    public static void main(String args[]) {
        // fill visited array
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }

        recursion(2, 1);

    }

    private static void recursion(int row, int col) {
        if (!isInBound(row, col) || visited[row][col])
            return;
        visited[row][col] = true;

        if (arry[row][col] == '1') {
            System.out.println("Found at " + row + " " + col);
            return;
        } else if (arry[row][col] == ' ') {
            recursion(row, col + 1);
            recursion(row - 1, col);
            recursion(row + 1, col);
            recursion(row, col - 1);

        }

    }

    private static boolean isInBound(int row, int col) {
        boolean bol = false;
        if (row < arry.length && col < arry[0].length && col >= 0 && row >= 0) {
            bol = true;
        }

        return bol;
    }
}