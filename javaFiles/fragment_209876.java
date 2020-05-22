public class Foo {

    public static void main(String[] args) {
        // Take your original array
        int[] arr = { 1, 4, 5, 10, 6, 8, 3, 9 };
        // Use the Arrays sort method to sort it into ascending order (note this mutates the array instance)
        Arrays.sort(arr);
        // Create a new array of the same length
        int[] minMaxSorted = new int[arr.length];
        // Iterate through the array (from the left and right at the same time)
        for (int i = 0, min = 0, max = arr.length - 1; i < arr.length; i += 2, min++, max--) {
            // the next minimum goes into minMaxSorted[i]
            minMaxSorted[i] = arr[min];
            // the next maximum goes into minMaxSorted[i + 1] ... but
            // guard against index out of bounds for odd number arrays
            if (i + 1 < minMaxSorted.length) {
                minMaxSorted[i + 1] = arr[max];
            }
        }
        System.out.println(Arrays.toString(minMaxSorted));
    }
}