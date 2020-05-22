import java.util.Scanner;

public class TicTacToe {

    public static int row,col;
    public static Scanner scan = new Scanner(System.in);

    public static char[][] board = new char[3][3];
    public static char turn = 'X';

    public static void main(String[] args) {

        for(int i = 0;i < 3; i++) {
            for(int j = 0;j < 3;j++){
                board[i][j] = '_';
            }

        }
        PrintBoard();
    }

    public static void Play() {

    }

    public static void PrintBoard() {
        for(int i = 0;i < 3; i++) {
            System.out.println();
            for(int j = 0;j < 3;j++) {
                if(j==0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " | ");
            }
        }
    }

    public boolean GameOver(int rMove, int cMove) {
        return false;
    }
}