int n = 3; // user input
char[][] board = new char[][] { { 'x', 'x', 'x' }, { '0', '0', '0' } }; //example board

for (int row = 0; row < board.length; row++)
{
    for (int i = 0; i < n; i++)
    {
        for (int col = 0; col < board[row].length; col++)
        {
            System.out.print(board[row][col]);
        }
        System.out.print("\t"); //arrays separated by tab
    }
    System.out.println();
}