public void mergeSort(int[] input) {
    if (input.length >= 2) {
        int[] left = copyOfRange(input, 0, input.length / 2);
        int[] right = copyOfRange(input, input.length / 2, input.length);
        mergeSort(left);
        mergeSort(right);
        for (int i = 0, j = 0, k = 0; i < left.length || j < right.length; k++) {
            if (i >= left.length || (j < right.length && left[i] > right[j]))
                input[k] = right[j++];
            else
                input[k] = left[i++];
        }
    }
}