public class MatrixService {

public static boolean isMagicSquare(int[][] arr) {
    final int size = arr.length;
    final int totalSize = size * size;
    final int magicNumber = (size * size * (size * size + 1) / 2) / size;
    int sumOfRow = 0, sumOfColoumns = 0, sumOfPrimaryDiagonal = 0, sumOfSecondaryDiagonal = 0;
    boolean[] flag= new boolean[size * size];

    for (int row = 0; row < size; row++) {
        sumOfRow = 0;
        sumOfColoumns = 0;
        for (int col = 0; col < size; col++) {
            if (arr[row][col] < 1 || arr[row][col] > totalSize) {
                return false;
            }
            if (flag[arr[row][col] - 1] == true) {
                return false;
            }
            flag[arr[row][col] - 1] = true;
            sumOfRow += arr[row][col];
            sumOfColoumns += arr[col][row];
        }
        sumOfPrimaryDiagonal += arr[row][row];
        sumOfSecondaryDiagonal += arr[row][n-row-1];

        if (sumOfRow != magicNumber || sumOfColoumns != magicNumber) {
            return false;
        }

        if (sumOfPrimaryDiagonal != magicNumber || sumOfSecondaryDiagonal != magicNumber) {
            return false;
        }

        return true;
    }

    public static void main(String []args){
        int[][] a ={{4,9,2},
                {3,5,7},
                {8,1,6}};
        System.out.println(isMagicSquare(a));
   }
}