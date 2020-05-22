import java.util.Arrays;

public class ArrayProgram {

    public static void main(String[] args) {
        int[][] array1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] array2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] array3 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        test(array1);
        test(array1, array2);
        test(array1, array2, array3);
    }

    private static void test(int[][]... arrays) {
        int[][] result = ArrayCopier.joinSecondDimension(arrays);
        for (int[] array : result) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println();
    }
}

class ArrayCopier {

    public static int[][] joinSecondDimension(int[][]... arrays) {
        int firstArrayLength = arrays[0].length;
        int[][] result = new int[firstArrayLength][];
        for (int index = 0; index < firstArrayLength; index++) {
            result[index] = join(getSecondDimArrays(index, arrays));
        }
        return result;
    }

    public static int[] join(int[]... arrays) {
        int[] result = new int[getTotalLength(arrays)];
        int destPos = 0;
        for (int[] array : arrays) {
            System.arraycopy(array, 0, result, destPos, array.length);
            destPos += array.length;
        }
        return result;
    }

    private static int getTotalLength(int[]... arrays) {
        int length = 0;
        for (int[] array : arrays) {
            length += array.length;
        }
        return length;
    }

    private static int[][] getSecondDimArrays(int index, int[][]... arrays) {
        int[][] result = new int[arrays.length][];
        int resultIndex = 0;
        for (int[][] array : arrays) {
            result[resultIndex++] = array[index];
        }
        return result;
    }
}