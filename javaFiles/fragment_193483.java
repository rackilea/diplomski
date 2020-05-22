import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MatrixMaxSum {
    public static void main(String[] args) {
        MatrixMaxSum maxSum = new MatrixMaxSum();
        Matrix matrix = maxSum.readInput();

        List<SubMatrixSum> subMatrices = maxSum.findAllSubMatrices(matrix);
        System.out.println("Total SubMatrices: " + subMatrices.size());
        SubMatrixSum subMatrixSum = subMatrices.stream().sorted((s1, s2) -> s2.sum.compareTo(s1.sum)).findFirst().get();

        System.out.println(subMatrixSum);
    }

    private List<SubMatrixSum> findAllSubMatrices(Matrix m) {
        List<SubMatrixSum> subs = new ArrayList<>();
        int row = 0, column;

        while (row < m.matrix.length - m.subMatrixSize + 1) {
            column = 0;
            while (column < m.matrix[0].length - m.subMatrixSize + 1) {
                int[][] sub = new int[m.subMatrixSize][m.subMatrixSize];
                int sum = 0;
                if (row == 0 || row == m.matrix.length || column == 0 || column == m.matrix[0].length) {
                    for (int i = 0, mi = row; i < m.subMatrixSize; i++, mi++) {
                        for (int j = 0, mj = column; j < m.subMatrixSize; j++, mj++) {
                            sub[i][j] = m.matrix[mi][mj];
                            sum += sub[i][j];
                        }
                    }
                    subs.add(new SubMatrixSum(sub, sum));
                }
                column++;
            }
            row++;
        }

        return subs;
    }

    private Matrix readInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Input width and height of matrix:");
            String line = br.readLine();
            String[] wh = line.split("\\s+");
            if (wh.length == 2) {
                int w = Integer.parseInt(wh[0]);
                int h = Integer.parseInt(wh[1]);
                int[][] m = new int[h][w];
                System.out.println("Input matrix with numbers from 0-9 :");
                for (int i = 0; i < h; i++) {
                    line = br.readLine();
                    String[] row = line.split("\\s+");
                    if (row.length == w) {
                        for (int j = 0; j < w; j++) {
                            m[i][j] = Integer.parseInt(row[j]);
                        }
                    } else {
                        throw new RuntimeException("Invalid input");
                    }
                }
                System.out.println("Input maximum width of square submatrix:");
                line = br.readLine();
                int sm = Integer.parseInt(line);
                if (sm > w || sm > h) {
                    throw new RuntimeException("Invalid input");
                }

                return new Matrix(m, sm);
            } else {
                throw new RuntimeException("Invalid input");
            }
        } catch (IOException e) {

        }
        return null;
    }
}

class SubMatrixSum {
    int[][] subMatrix;
    Integer sum;

    public SubMatrixSum(int[][] subMatrix, Integer sum) {
        super();
        this.subMatrix = subMatrix;
        this.sum = sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix: \n");
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[i].length; j++) {
                sb.append(subMatrix[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append("Sum: " + sum);
        return sb.toString();
    }
}

class Matrix {
    int[][] matrix;
    int subMatrixSize;

    public Matrix(int[][] matrix, int subMatrixSize) {
        super();
        this.matrix = matrix;
        this.subMatrixSize = subMatrixSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}