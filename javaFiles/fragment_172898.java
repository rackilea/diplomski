import java.util.*;
public class BinarySearch {
    static int findMinimum(Integer[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (arr[low] > arr[high]) {
            int mid = (low + high) >>> 1;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // must be in sorted order, allowing rotation, and contain no duplicates

        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr));
            int minIndex = findMinimum(arr);
            System.out.println(" Min is " + arr[minIndex] + " at " + minIndex);
            Collections.rotate(Arrays.asList(arr), 1);
        }
    }
}