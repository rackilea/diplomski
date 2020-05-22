public class RecursiveMethod {
    public static int RecursiveBinarySearch(int[] array, int l, int h, int x) {
        if (h>=l)
            int mid = l + (h-l)/2;

        if (x == array[mid])
            return mid;
        else if ( l == h)
            return -1;
        else if (x < array[mid])
            return RecursiveBinarySearch(array, l, mid-1, x);
        if (x > array[mid])   // last possibility: x > array[mid]
            return RecursiveBinarySearch(array, mid+1, h, x);
    }
}