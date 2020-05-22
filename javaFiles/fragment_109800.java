import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] numbers = {3, 9, 6, 1, 34};

        int low = 0;

        int high = numbers.length - 1;

        quicksort(numbers, low, high);  

    }

    static void quicksort(int[] arr, int low, int high) {

        int i = low;
        int j = high;

        int middle = arr[(low + high) / 2];

        while(i <= j) {      
            while(arr[i] < middle ) {
                i++;
            }

            while(arr[j] > middle) {
                j--;
            }

            if( i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }


        }

        if(low < j) {
            quicksort(arr, low, j);         
        }

        if(i < high) {
            quicksort(arr, i, high);
        }

        System.out.println(Arrays.toString(arr));

    }

}