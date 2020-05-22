public class QuickSortImpl {

    private static void swap(int[] array, int l, int h) {
        int temp = array[h];
        array[h] = array[l];
        array[l] = temp;
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = high;
        int firsthigh = low;
        int x,y;

        for (int i = low; i < high; i++) {
            x = array[i];
            y = array[pivot];
            if (array[i] < array[pivot]) {
                swap(array, i, firsthigh);
                firsthigh++;
            }
        }
        swap(array, pivot, firsthigh);
        return firsthigh;
    }

    private static void printArray(int[] arr ) {
        for ( int i =0; i < arr.length; i++ ) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static void quickSort(int[] array, int low, int high) {
        if ( low < high ) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high); 
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 22, 1, 5, 6, 10, 4};
        quickSort(arr, 0, arr.length -1 );
        printArray(arr);
    }
}