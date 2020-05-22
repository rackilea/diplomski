package playground.tests;

import java.util.Arrays;

import junit.framework.TestCase;

public class BiggerTest extends TestCase {

    public void testBigger() throws Exception {
        int mat[][] = { { 3, 1, 2 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] result = bigger(0, 2, mat);
        assertEqualArrays(new int[] { 2, 3 }, result);
    }

    public void testBiggerDoesntChangeOriginalMatrix() throws Exception {
        int mat[][] = { { 3, 1, 2 }, { 4, 5, 6 }, { 7, 8, 9 } };
        bigger(0, 2, mat);
        assertEqualArrays(new int[] { 3, 1, 2 }, mat[0]);
    }

    public void testBiggerIndex() throws Exception {
        int mat[][] = { { 3, 1, 2 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] result = biggerIndexes(0, 2, mat);
        assertEqualArrays(new int[] { 2, 0 }, result);
    }

    private int[] biggerIndexes(int rowIndex, int count, int[][] matrix) {
        int[] biggerValues = bigger(rowIndex, count, matrix);
        int[] row = matrix[rowIndex];
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) 
            result[i] = findIndex(biggerValues[i], row);
        return result;
    }

    private int findIndex(int value, int[] values) {
        for (int i = 0; i < values.length; i++) 
            if (values[i] == value)
                return i;
        return -1;
    }

    private int[] bigger(int rowIndex, int count, int[][] matrix) {
        int[] row = copy(matrix[rowIndex]);
        Arrays.sort(row);
        int[] result = new int[count];
        for (int i = 0; i < count; i++)
            result[i] = row[i + row.length - count];
        return result;
    }

    private static int[] copy(int[] original) {
        int[] result = new int[original.length];
        for (int i = 0; i < result.length; i++) 
            result[i] = original[i];
        return result;
    }

    private static void assertEqualArrays(int[] a, int[] b) {
        assertEquals(a.length, b.length);
        for (int i = 0; i < a.length; i++)
            assertEquals(a[i], b[i]);
    }
}