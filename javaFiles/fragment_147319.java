import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {

        int[][] a = new int[][] { { 1, 2 }, { 3, 4 } }; // first array
        int[][] b = a;                                  
        int[][] c = a;                                  
        System.out.println("Eneter the multilpicity : ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n < 2){                                      // As we need minimum two matrix for multiplication
                                                        // Incase given multiplicity less than 2 it will not produce any difference 
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[0].length; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();

            }
            System.exit(0);
        }else if (n > 2) {                          
            while (n >= 2) {                        
                c = multiply(c, b); n--;
            }
        } else {
            c = multiply(c, b);                     
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int rowsInA = a.length;
        int columnsInA = a[0].length; // same as rows in B
        int columnsInB = b[0].length;
        int[][] c = new int[rowsInA][columnsInB];
        for (int i = 0; i < rowsInA; i++) {
            for (int j = 0; j < columnsInB; j++) {
                for (int k = 0; k < columnsInA; k++) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

}