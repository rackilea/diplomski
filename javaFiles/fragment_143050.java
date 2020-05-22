public class A3Q1_40011419 {
    //Creating the board for the user input
    static char [][] board = {{'1','2','3'}, {'4','5','6'},{'7','8','9'}};
    static Scanner keyboard = new Scanner (System.in);

    //Keeping track of the turns
    public static int turns = 0;

    //Drawing the board
    public static void drawBoard() {
        int row = 0;
        int col = 0;
        int turn = 0;

        for (row = 0; row < board.length; row++){
            for (col = 0; col < board[row].length; col++){
                System.out.print(board[row][col]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    //Asking user for input
    public static void getInput (int playerNum) {
        char piece;
        char location = ' ';



        if (playerNum != 1){
            System.out.println("Player X - Enter the position you wish to mark.");
            location = keyboard.next().charAt(0);
            piece = 'X';

        }
        else{
            System.out.println("Player O - Enter the position you wish to mark.");
            location = keyboard.next().charAt(0);
            piece = 'O';
        }

        //------------------------
        // Your new check
        int locationInt = Integer.parseInt("" + location);
        int x = (locationInt-1)/3;
        int y =  ((locationInt-1)%3);
        if (board[x][y] == 'X' || board[x][y] == 'O'){
            System.out.println("Position not available");   //This is was i tried to do so far to check is the position was available on the board. Not working
            getInput(playerNum);
            return;
        }
        //------------------------


        if (location == '1')
            if (board[0][0]=='1')
                board[0][0] = piece;
            else getInput(playerNum);

        else if (location == '2')
            if (board[0][1] == '2')
                board[0][1] = piece;
            else getInput(playerNum);

        else if (location == '3')
            if (board[0][2] == '3')
                board[0][2] = piece;
            else getInput(playerNum);

        else if (location == '4')
            if (board[1][0] == '4')
                board[1][0] = piece;
            else getInput(playerNum);

        else if (location == '5')
            if (board[1][1] == '5')
                board[1][1] = piece;
            else getInput(playerNum);

        else if (location == '6')
            if (board[1][2] == '6')
                board[1][2] = piece;
            else getInput(playerNum);

        else if (location == '7')
            if (board[2][0] == '7')
                board[2][0] = piece;
            else getInput(playerNum);

        else if (location == '8')
            if (board[2][1] == '8')
                board[2][1] = piece;
            else getInput(playerNum);

        else if (location == '9')
            if (board[2][2] == '9')
                board[2][2] = piece;
            else getInput(playerNum);


        else if (location != '1' || location !='2' || location !='3' || location != '4' || location !='5' || location !='6' || location != '7' || location != '8'|| location !='9'){
            System.out.println("That is not a valid position - must be between 1 and 9 inclusive.");
            getInput(playerNum);
        }
    }


//Checking if position available

    public static void isAvailable(){ //This is a method i thought of creating to check if the position was available but I have not used it yet.

        char location_1 = ' ';
        char location_2 = ' ';
        char location_3 = ' ';
        char location_4 = ' ';
        char location_5 = ' ';
        char location_6 = ' ';
        char location_7 = ' ';
        char location_8 = ' ';
        char location_9 = ' ';

    }


/*Checking if there is a winner by checking if the cells in the board are equal to each other
*and checking if the cell isn't empty. If one isn't empty and they're all equal, then
none of them is empty.*/

    public static char isWinner() {

        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0]!='1')
            return board[0][0];
        else if (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0]!='1')
            return board[0][0];
        else if (board[0][0]==board[0][1] && board[0][0]==board[0][2] && board[0][0]!='1')
            return board[0][0];
        else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] !='3')
            return board[0][2];
        else if (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != '3')
            return board[0][2];
        else if (board[2][0] == board [2][1] && board[2][0] == board[2][2] && board[2][0] != '7')
            return board[2][0];
        else if (board[1][0] == board [1][1] && board[1][0] == board[1][2] && board[1][0] != '4')
            return board[1][0];
        else if (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != '2')
            return board[0][1];
        else
            return 'Y';

    }

    //New board for a new game
    public static void newBoard() {
        board[0][0] = '1';
        board[0][1] = '2';
        board[0][2] = '3';
        board[1][0] = '4';
        board[1][1] = '5';
        board[1][2] = '6';
        board[2][0] = '7';
        board[2][1] = '8';
        board[2][2] = '9';
    }

        //Main method
    public static void main(String[] args) {

        int game = 0;

        int playerNum = 1;
        String answer;
        do {
            turns = 0;
            newBoard();
            while (isWinner() == 'Y') {
                drawBoard();
                isWinner();
                playerNum *= -1;
                getInput(playerNum);
                turns++;
                System.out.println(turns);

                if (turns == 9) {
                    break;
                }
            }
            drawBoard();
            if (isWinner() == 'X')
                System.out.println("Player X wins");
            else if (isWinner()=='O')
                System.out.println("Player O wins");
            else
                System.out.println("It's a tie!");

            System.out.println("Would you like to play another game?");
            answer = keyboard.next().toLowerCase();
        }
        while (answer.equals("yes"));
    }
}