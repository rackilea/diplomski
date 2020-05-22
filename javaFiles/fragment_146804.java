import java.util.Scanner;

public class Matrices {

    int i, j, k, n = 3;
    int[][] matA = new int[n][n];
    int[][] matB = new int[n][n];
    int[][] matSum = new int[n][n];
    int[][] matProd = new int[n][n];

    public void readInput() {
        Scanner scan = new Scanner(System.in);
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.println("matA[" + i + "][" + j + "]");
                matA[i][j] = scan.nextInt();
                System.out.println("matB[" + i + "][" + j + "]");
                matB[i][j] = scan.nextInt();
            }
        }
    }

    public void findSum() {
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                matSum[i][j] = matA[i][j] + matB[i][j];
            }
        }
    }

    public void findProduct() {
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                for (k = 0; k < n; k++) {
                    matProd[i][j] = matProd[i][j] + matA[i][j] * matB[i][j];
                }
            }
        }
    }

    public void displayResult() {
        // Printing the Sum Matrix
        System.out.println("Sum Matrix is:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.println(matSum[i][j] + " ");
            }
        }

        // Printing the Product Matrix
        System.out.println("Product Matrix is:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.println(matProd[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Matrix Calculator");
        System.out.println("-------------------\n");
        Matrices self = new Matrices();

        self.readInput();
        self.findSum();
        self.findProduct();
        self.displayResult();
    }
}