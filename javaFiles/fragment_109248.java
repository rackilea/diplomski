public static void main(String[] args)
{
    //list of rows, where each row has 4 values
    int[][] board = new int[][] { {2,3,1,1}, {1,2,1,1},{2,3,3,3}, {4,2,3,3}};
    Sudoku sudoku = new Sudoku(board);
    sudoku.solve();
    sudoku.print();
}