public class matrix {
    public static void main(String[] args) {
        int n = 5;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                a[i][j] = i * n + j + 1;
            }
        }
        rotateMatrix(a);
        for (int i = 0; i < a.length; i ++) {
            for (int j = 0; j < a[0].length; j ++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }
    }
    public static void rotateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length / 2; i++) {
            int top = i;
            int bottom = matrix.length - 1 - i;
            for (int j = top; j < bottom; j++) {
                int temp = matrix[top][j];
                matrix[top][j] = matrix[j][bottom];
                matrix[j][bottom] = matrix[bottom][bottom - (j - top)];
                matrix[bottom][bottom - (j - top)] = matrix[bottom - (j - top)][top];
                matrix[bottom - (j - top)][top] = temp;
            }
        }
    }
}