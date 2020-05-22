import java.util.Arrays;
import java.util.Random;

class Test {
    public static void main(String[] args){
        int size = 9;

        int[][] matrix= new int[size][];
        matrix[0] = MatrixOps.createOrderedArray(size, 1);

        for(int x=0; x < size; x++) {
            matrix[x] = MatrixOps.createOrderedArray(size, 1);
            do {
                MatrixOps.shuffle(matrix[x]);
            } while(! MatrixOps.compare2DArray(matrix[x], matrix, 0, x));
        }
        MatrixOps.print(matrix);
    }
}

class MatrixOps {

    public static void shuffle(int[] arr){
        Random random = new Random();
        for(int x = 0; x < arr.length; x++)
            swap(arr, x, random.nextInt(arr.length));
    }

    public static int[] createOrderedArray(int size, int startValue) {
        int[] num = new int[size];
        for (int x = 0; x < num.length; x++)
            num[x] = x + startValue;
        return num;
    }

    public static boolean compare2DArray(int[] arr1, int[][] arr2, int begin, int end) {
        for (int x = begin; x < end; x++)
            if (!compareArray(arr1, arr2[x]))
                return false;
        return true;
    }

    // https://stackoverflow.com/questions/19648240/java-best-way-to-print-2d-array/41533179#41533179
    public static void print(int[][] array) {
        for (int[] x: array) {
            for (int y: x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    private static boolean compareArray(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length)
            return false;
        for(int x=0; x<arr1.length; x++)
            if(arr1[x] == arr2[x])
                return false;
        return true;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}