public class Matrix {

    public static int[][] readMatrix() {

        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        System.out.println("Please insert how many rows and columns you want for matrix");
        int ColumnsAndRows = in.nextInt();

        int matrix[][] = new int[ColumnsAndRows][ColumnsAndRows];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = rand.nextInt(ColumnsAndRows * ColumnsAndRows) + 1;
            }
        }

        return matrix;
    }

    public static void printMatrix(int matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println("");
        }
    }

    public static void swapDiagonals(int matrix[][]) {
        int ColumnsAndRows = matrix.length;
        for (int i = 0; i < ColumnsAndRows; i++) {
            int temp = matrix[i][i];
            matrix[i][i] = matrix[i][ColumnsAndRows - i - 1];
            matrix[i][ColumnsAndRows - i - 1] = temp;
        }
        printMatrix(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = readMatrix();
        printMatrix(matrix);
        System.out.println("swapDiagonals:");
        swapDiagonals(matrix);
    }
}