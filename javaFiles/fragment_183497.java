public class BinarySearch {

    public static void main(String[] a) {
        int[] numArray = {5,6,10,11,19,18,30,25,88,44,55,1,3};
        Arrays.sort(numArray);
        // performing a binary search - here 100 is the element that you want 
            // to search in your array
        System.out.println(searchElement(numArray, 100));
    }

    private static int searchElement(int[] sortedArray, int element) {

        int first = 0;
        int upto  = sortedArray.length;

        while (first < upto) {
            int mid = (first + upto) / 2;  // Compute mid point.
            if (element < sortedArray[mid]) {
                upto = mid;       // repeat search in bottom half.
            } else if (element > sortedArray[mid]) {
                first = mid + 1;  // Repeat search in top half.
            } else {
                return sortedArray[mid];       // Found it. You can return the position or the element
            }
        }
        return -1;    // The element is not in the array
    }
}