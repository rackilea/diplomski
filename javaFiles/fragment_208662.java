import java.util.Arrays;

public class ArrayProgram {

    public static void main(String[] args) {
        int[][] array1 = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
        int[][] array2 = { { 4, 5, 6 }, { 7, 8, 9 }, { 0, 1, 2 } };
        int[][] result = ArrayCopier.joinSecondDimension(array1, array2);
        for (int[] array : result) {
            System.out.println(Arrays.toString(array));
        }
    }
}

class ArrayCopier {

    public static int[][] joinSecondDimension(int[][] array1, int[][] array2) {
        int[][] array1and2 = new int[array1.length][];
        for (int index = 0; index < array1.length; index++) {
            array1and2[index] = join(array1[index], array2[index]);
        }
        return array1and2;
    }

    public static int[] join(int[] array1, int[] array2) {
        int[] array1and2 = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, array1and2, 0, array1.length);
        System.arraycopy(array2, 0, array1and2, array1.length, array2.length);
        return array1and2;
    }
}