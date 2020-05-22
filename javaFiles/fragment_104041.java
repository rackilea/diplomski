public class Sorter {
    public static int[] mergeSort(int[] input) {
        if (input.length < 2) {
            return input;
        }
        int mid = input.length / 2;
        int[] left = Arrays.copyOfRange(input, 0, mid);
        int[] right = Arrays.copyOfRange(input, mid, input.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] output = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                output[k++] = left[i++];
            } else {
                output[k++] = right[j++];
            }
        }
        while (i < left.length) {
            output[k++] = left[i++];
        }
        while (j < right.length) {
            output[k++] = right[j++];
        }
        return output;
    }

    public static void main(String args[]) {
        int[] input = new int[]{2, 4, 1, 6, 8, 5, 3, 7};
        System.out.println(Arrays.toString(Sorter.mergeSort(input)));
    }
}