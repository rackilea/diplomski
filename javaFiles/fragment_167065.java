import java.util.Scanner;

public class one {

    public static void main(String args[]) {
        int p[][] = null;
        System.out.println("Type ur array here:");
        System.out.println("how many rows and column:");
        int row, colmn;
        Scanner u = new Scanner(System.in);

        // Only one is required to read from standard input stream, instead of:
        // Scanner y = new Scanner(System.in);
        // Scanner t = new Scanner(System.in);
        // Scanner r = new Scanner(System.in);

        // Use Scanner object "u":
        row = u.nextInt();
        colmn = u.nextInt();

        // Memory to array:
        p = new int[row][colmn];

        // Change '<=' to '<' as arrays are 0 index and will give index out of bounds exception ;
        // Or change 'p = new int[row][colmn];' to 'p = new int[row + 1][colmn + 1];'.
        for(int i = 0; i < row; i++){
            for(int v = 0; v < colmn; v++){
                int j = u.nextInt();
                // Change indices to "i, v" instead of "row, colmn":
                p[i][v]=j;
            }

        }
        // Bad way to copy array as same reference is going to be used.
        // To copy array use the following:

        /* 
         * // int a[][] = p;
         * int[][] a = new int[row][colmn];
         * for (int i = 0; i < row; i++) {
         *     System.arraycopy(p[i], 0, a[i], 0, colmn);
         * }
         */

        int a[][] = p;
        System.out.println("The given array:");
        y(a);

    }
    public static void y(int n[][]){

        for(int i = 0; i < n.length; i++){
            for(int j = 0; j < n[i].length; j++)
                System.out.print(n[i][j]);
            System.out.println();
        }   
    }

 }