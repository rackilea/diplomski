import java.util.Scanner;
public class TicTacToe
{
    private final static int ROWS = 3;
    private final static int COLUMNS = 3;
    private char[][] gameBoard;
    private int player1WinCount = 0;
    private int player2WinCount = 0; 
    private char player1Move = 'X', player2Move = 'O';
    private boolean playerX = true;

    Scanner in = new Scanner(System.in);

    public TicTacToe()
    {
        gameBoard  = new char [ROWS][COLUMNS];
        playerX = true;
        startGame();
    }

    //Initiate the game board with all empty spaces. 
    public void startGame()
    {
        for (int row = 0; row < ROWS; row++) //Loop through rows.
            for(int col = 0; col < COLUMNS; col++) //Loop through columns.
                gameBoard[row][col]= ' ';
    }

    public boolean checkTurn()
    {
        if (playerX)
        {
            System.out.println("Player X's turn.");
        }
        else
        {
            System.out.println("Player O's turn.");
        }
        return playerX;
    }

    public void addMove()
    {
        int row, col;
        do
        {
        checkTurn();
        System.out.println("Enter a row (1-3): ");
        row = in.nextInt() - 1; //Array index starts at 0.
        System.out.println("Enter a column (1-3): ");
        col = in.nextInt() - 1;

        if(notValid(row,col)){
            // do not proceed
            System.out.println("Invalid Entry.");
            continue;
        }

        if (row>=0 && row<ROWS)
            if(col>=0 && col<COLUMNS)
                if (playerX)
                    {
                        gameBoard[row][col] = player1Move;
                    }
                    else 
                    {
                        gameBoard[row][col] = player2Move;
                    }
         boolean hasWon = checkForWin();
         if(hasWon)
         {
             System.out.println("You won");
             if(playerX)
             {
                 player1WinCount++;          
             }
             else
             {
                 player2WinCount++;
             }
             break;
         }
         changePlayer();
        }while (true);
    }

    public boolean notValid(int row, int col)
    {
        if (row < 0 || row > (ROWS - 1))
            return true;
        if (col < 0 || col > (COLUMNS - 1))
            return true;
        if (!isEmpty(row,col))
            return true;
        return false;
    }

    public boolean isEmpty(int row, int col)
    {
        if(gameBoard[row][col]==' ')
            return true;
        else
        {
            System.out.println("Space is already occupied.");
            return false;
        }
    }
    public void changePlayer()
    {
        if (playerX)
        {
            playerX = false;
        }
        else
        {
            playerX = true;
        }
    }
    public void printBoard()
    {
        for (int row = 0; row < ROWS; row++){
            for (int col = 0; col < COLUMNS; col++)
            {        
                System.out.print("" + gameBoard[row][col]);
                if(col == 0 || col == 1)
                    System.out.print("|");

            }
            if (row ==0 || row ==1)
            System.out.print("\n-----\n");
        }   
    }
    /**
     * This method checks to see if a winner.
     * return true is there is a winner. 
     */
    public boolean checkForWin()
    {
        //checks rows for win
        for(int row = 0; row < ROWS; row ++)
        {
            if (gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1]==gameBoard[row][2] && gameBoard[row][0]!= ' ')
            return true;    
        }       
        //checks columns for wins.
        for (int col = 0;  col < COLUMNS; col++)
        {   
            if (gameBoard[0][col] == gameBoard[1][col]&& gameBoard[1][col]==gameBoard[2][col] && gameBoard[0][col]!= ' ')
            return true;
        }
        //check the diagonals for wins.
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0]!= ' ')
            return true;
        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] && gameBoard[0][2]!= ' ')
            return true;

        return false; 
    }

    public static void main(String args[])
    {
        TicTacToe game = new TicTacToe();
        game.addMove();
        game.printBoard();
    }
}