//initialize variables
char[][] board = new char[3][3];
int playerRow = 0;
int playerCol = 0;

//clear the board
for(int row = 0; row < board.length; row++){
    for (int col = 0; col < board[row].length; col++){
        board[row][col] = '-';
    }
}

Scanner kbd = new Scanner(System.in);

System.out.println("Lets play a simple game of tic-tac-toe");
System.out.println("Player 1 (X's) : Please enter a row number and column number ");
System.out.println(" in order to plot the cordinates of your desired move");

//get player's row and column
playerRow = kbd.nextInt();
playerCol = kbd.nextInt();

//Change the chosen spot to be the player's character.
board[playerRow][playerCol] = 'X';

//Display the board
for(int row = 0; row < board.length; row++){
    for(int col = 0; col < board[row].length;col++){
        System.out.print(board[row][col] + " ");
    }
    System.out.println();
}