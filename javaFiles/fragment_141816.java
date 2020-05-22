import java.util.Random;

public class TicTacToe {
  private static final int DIMENSION = 3;

  public static void main(String[] args) {
    System.out.println("Welcome to random Tic Tac Toe Checker. Let's see our randomly generated board.");
    char[][] board = new char[DIMENSION][DIMENSION];
    final Random r = new Random();

    for (int i = 0; i < DIMENSION; i++) {
      for (int j = 0; j < DIMENSION; j++) {
        int choice = r.nextInt(2);
        if (choice == 0) {
          board[i][j] = 'X';
        } else if (choice == 1) {
          board[i][j] = 'O';
        }
      }
    }
    for (int i = 0; i < DIMENSION; i++) {
      for (int j = 0; j < DIMENSION; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }


    boolean xWin = false;
    boolean oWin = false;

    for (int i = 0; i < DIMENSION; i++) {
      boolean lineWin = true;
      for (int j = 0; j < DIMENSION; j++) {
        if (board[i][j] != board[i][0]) {
          lineWin = false;
        }
      }
      if (lineWin) {
        if (board[i][0] == 'X') {
          xWin = true;
        }
        if (board[i][0] == 'O') {
          oWin = true;
        }

      }
    }
    for (int j = 0; j < DIMENSION; j++) {
      boolean lineWin = true;
      for (int i = 0; i < DIMENSION; i++) {
        if (board[i][j] != board[0][j]) {
          lineWin = false;
        }
      }
      if (lineWin) {
        if (board[0][j] == 'X') {
          xWin = true;
        }
        if (board[0][j] == 'O') {
          oWin = true;
        }

      }
    }
    boolean lineWin = true;
    for (int i = 0; i < DIMENSION; i++) {
      if (board[0][0] != board[i][i]) {
        lineWin = false;
      }
    }
    if (lineWin) {//this check should not be in the loop
      if (board[0][0] == 'X') {
        xWin = true;
      }
      if (board[0][0] == 'O') {
        oWin = true;
      }

    }
    lineWin = true;
    for (int i = 0; i < DIMENSION; i++) {
      if (board[DIMENSION - 1][0] != board[i][DIMENSION - 1 - i]) {
        lineWin = false;
      }
    }
    if (lineWin) {//this check should not be in the loop
      if (board[DIMENSION - 1][0] == 'X') {
        xWin = true;
      }
      if (board[DIMENSION - 1][0] == 'O') {
        oWin = true;
      }
    }
    if (xWin == true && oWin == true) {//printing winners
      System.out.println("Both players won!");
    }
    if (xWin == false && oWin == false) {
      System.out.println("CAT!It's a tie no one wins");
    }
    if (xWin == true) {
      System.out.println("X wins!");
    }

    if (oWin == true) {
      System.out.println("O wins!");
    }
  }
}