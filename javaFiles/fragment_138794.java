package com.gmail.jackkobec.java.core;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Jack <jackkobec>
 */
public class MatrixInitialisationAndPrint {
    public static final int ROWS_COUNT = 5; // Matrix rows number
    public static final int COLUMN_COUNT = 3; // Matrix columns number

    public static void main(String[] args) {
        // Init matrix in method by random int values from up to 777
        int[][] matrix = initMatrix(ROWS_COUNT, COLUMN_COUNT);
        // Print matrix
        printMatrix(matrix);
    }

    /**
     * Init matrix by random int values with border 777
     *
     * @param rowsCount    - Matrix rows number
     * @param columnsCount - Matrix columns number
     * @return int[][]
     */
    public static int[][] initMatrix(int rowsCount, int columnsCount) {
        int[][] matrix = new int[ROWS_COUNT][COLUMN_COUNT];
        for (int r = 0; r < rowsCount; r++) {
            for (int c = 0; c < columnsCount; c++) {
                matrix[r][c] = new Random().nextInt(777);
            }
        }

        return matrix;
    }

    /**
     * Prints matrix.
     *
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).map(array -> Arrays.toString(array) + "\n").forEach(System.out::println);
    }
}