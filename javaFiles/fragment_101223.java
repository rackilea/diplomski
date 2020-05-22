package hts;


public class HTS {

static int[][] sudoku = new int[9][9];

public static void printBoard() {
    for (int i = 0; i < 9; i++) {
            System.out.print("\n");
            if(i%3==0)
                System.out.print("\n");
        for (int j = 0; j < 9; j++) {
            if (j % 3 == 0)
                System.out.print(" ");
            if (sudoku[i][j] == 0)
                System.out.print(". ");
            if (sudoku[i][j] == 1)
                System.out.print("1 ");
            if (sudoku[i][j] == 2)
                System.out.print("2 ");
            if (sudoku[i][j] == 3)
                System.out.print("3 ");
            if (sudoku[i][j] == 4)
                System.out.print("4 ");
            if (sudoku[i][j] == 5)
                System.out.print("5 ");
            if (sudoku[i][j] == 6)
                System.out.print("6 ");
            if (sudoku[i][j] == 7)
                System.out.print("7 ");
            if (sudoku[i][j] == 8)
                System.out.print("8 ");
            if (sudoku[i][j] == 9)
                System.out.print("9 ");
        }
    }
}

public static void main(String[] args) {
    printBoard();
}

}