import java.util.*;

public class TicTacMessAroundCode {

   //declare constants
   public static final int BLANK = 0;
   public static final int EX = 1;
   public static final int CIRCLE = 2;

   // Name-constants to represent the various states of the game
   public static final int PLAYING = 0;
   public static final int DRAW = 1;
   public static final int EX_WON = 2;
   public static final int CIRCLE_WON = 3;

   // The game board and the game status
   public static final int SIZE = 3; //size of each row and each column
   public static int[][] board = new int[SIZE][SIZE]; // game board

   public static int currentState;  // the current state of the game
                                    // (PLAYING, DRAW, EX_WON, CIRCLE_WON)
   public static int currentPlayer; // the current player (EX or CIRCLE)
   public static int currentRow, currentCol; // current seed's row and column

   public static Scanner in = new Scanner(System.in); 

   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
      // Initialize the game-board and current status
      initializeBoard();
      //Start playing game
      do {
         getMove(currentPlayer); // update currentRow and currentCol
         updateGame(currentPlayer, currentRow, currentCol); // update currentState
         displayBoard();
         // Print message if game-over
         if (currentState == EX_WON) {
            System.out.println("'X' player won!");
         } else if (currentState == CIRCLE_WON) {
            System.out.println("'O' player won!");
         } else if (currentState == DRAW) {
            System.out.println("It's a Draw!!");
         }
         // Switch player
         currentPlayer = (currentPlayer == EX) ? CIRCLE : EX;
      } while (currentState == PLAYING); // repeat if not game-over
   }

   //initializeBoard method
   public static void initializeBoard() {
      for (int row = 0; row < SIZE; ++row) {
         for (int col = 0; col < SIZE; ++col) {
            board[row][col] = BLANK;  // all cells empty
         }
      }
      currentState = PLAYING; // ready to play

      System.out.println("Who wants to go first (X or O)? ");
      Scanner xOrO = new Scanner(System.in);
      String entOp = xOrO.nextLine();
      char enterOp = entOp.charAt(0);

      if (enterOp == 'X'){  
         currentPlayer = EX;  // X plays first
      } else {
         currentPlayer = CIRCLE;
      }
   }

   //getMove method: to prompt the current player for target position. 
   public static void getMove(int theSeed) {    
      boolean validInput = false;  // for input validation
      do {

          int row = 0;   // Changed scope of these variables.
          int col = 0;   // Changed scope of these variables.

      if (theSeed == EX){
           System.out.println("Enter a row (0,1,2) for player X: ");
         row = in.nextInt(); // Removed "- 1"
          System.out.println("Enter a column (0,1,2) for player X: ");
         col = in.nextInt(); // Removed "- 1" 
      }  else {
           System.out.println("Enter a row (0,1,2) for player O: ");
         row = in.nextInt(); // Removed "- 1"      
           System.out.println("Enter a column (0,1,2) for player O: ");
         col = in.nextInt(); // Removed "- 1"
      }            
         if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == BLANK) {
            currentRow = row;
            currentCol = col;
            board[currentRow][currentCol] = theSeed;  // update game-board content
            validInput = true;  // input okay, exit loop
         } else {
            System.out.println("This move at (" + (row) + "," + (col) // column adjustment
                  + ") is not valid. Try again...");
         }
      } while (!validInput);  // repeat until input is valid
   }

   /** Update the "currentState" after the player with "theSeed" has placed on
       (currentRow, currentCol). */
   public static void updateGame(int theSeed, int currentRow, int currentCol) {
      if (findWinner(theSeed, currentRow, currentCol)) {  // check if winning move
         currentState = (theSeed == EX) ? EX_WON : CIRCLE_WON;
      } else if (isDraw()) {  // check for draw
         currentState = DRAW;
      }
      // Otherwise, no change to currentState (still PLAYING).
   }

   /** Return true if it is a draw (no more empty cell) */
   // TODO: Shall declare draw if no player can "possibly" win
   public static boolean isDraw() {
      for (int row = 0; row < SIZE; ++row) {
         for (int col = 0; col < SIZE; ++col) {
            if (board[row][col] == BLANK) {
               return false;  // an empty cell found, not draw, exit
            }
         }
      }
      return true;  // no empty cell, it's a draw
   }

   /** Return true if the player with "theSeed" has won after placing at
       (currentRow, currentCol) */
   public static boolean findWinner(int theSeed, int currentRow, int currentCol) {
      return (board[currentRow][0] == theSeed         // 3-in-the-row
                   && board[currentRow][1] == theSeed
                   && board[currentRow][2] == theSeed
              || board[0][currentCol] == theSeed      // 3-in-the-column
                   && board[1][currentCol] == theSeed
                   && board[2][currentCol] == theSeed
              || currentRow == currentCol            // 3-in-the-diagonal
                   && board[0][0] == theSeed
                   && board[1][1] == theSeed
                   && board[2][2] == theSeed
              || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
                   && board[0][2] == theSeed
                   && board[1][1] == theSeed
                   && board[2][0] == theSeed);
   }

   //displayBoard method/ 
   public static void displayBoard() {
      System.out.println("-------------");
      for (int row = 0; row < SIZE; ++row) {
      System.out.print("|");
         for (int col = 0; col < SIZE; ++col) {
            printCell(board[row][col]); 
            if (col != SIZE) {
               System.out.print("|");   
            }
         }
         System.out.println();
         if (row != SIZE) {
            System.out.println("-------------"); 
         }
      }
      System.out.println();
   }

   /** Print a cell with the specified "content" */
   public static void printCell(int content) {
      switch (content) {
         case BLANK:  System.out.print("   "); break;
         case CIRCLE: System.out.print(" O "); break;
         case EX:  System.out.print(" X "); break;
      }
   }
}