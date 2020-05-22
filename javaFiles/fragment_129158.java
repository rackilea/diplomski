public class NQueenProblem {
    static void printSolution(int board[][])
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(" "+board[i][j]+" ");
            System.out.println();
        }
    }    
    static void solveNQUtil(int leadingZeros, int startingRow, int board[][])
    {
        int columns = board[0].length;

        if (leadingZeros == columns) return;

        for (int ones = 1; leadingZeros+ones <= columns ; ones++) 
        {
            int curRow = startingRow + ones - 1;

            for (int i=0 ; i<ones ; i++) board[curRow][i+leadingZeros] = 1;
        }

        solveNQUtil(leadingZeros + 1, startingRow + columns - leadingZeros, board);
    }

    public static void main(String[] args) 
    {
        int totalColumns = 4;
        int rows = (int)((totalColumns+1)*totalColumns*0.5); //

        int board[][] = new int[rows][totalColumns];

        solveNQUtil(0, 0, board);
        printSolution(board);
    }
}