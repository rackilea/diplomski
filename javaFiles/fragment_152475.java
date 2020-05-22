import java.util.Random;

public class MatrixTest {

    public static void subMatrix(int startRow, int startCol, int[][] mat) {

        System.out.print("Submatrix for : ");
        System.out.println(startRow + ", " + startCol);
        shiftMatrix(startRow, startCol, mat);
    }

    public static void shiftMatrix(int startRow, int startCol, int[][] mat) {
        int[][] d = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //to properly move within the 3x3 you only need to add a 
                //constant buffer to the indices of mat[][]
                d[i][j] = mat[i + startRow][j + startCol]; 
            }
        }
        System.out.println("Your 3*3 SubMatrix is : ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(d[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        int[][] mat = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++){
                Random rand = new Random();
                mat[i][j] = rand.nextInt(10);
            }
        }

        //copying large matrix to another for passing by argument 

        System.out.println("Copied matrix is : ");
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
        //Here is the 3*3 submatrix traversing starts...

        for (int i = 1; i < 5; i++) { //changed from i < 6 to i < 5 to stay inside 7x7
            for (int j = 1; j < 5; j++) {
                subMatrix(i, j, mat);
            }
        }
    }
}