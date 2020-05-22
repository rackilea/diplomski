public static void main(String[] args) {
    int[] array = {6, 30, 7, 23, 4, 8, 9, 10, 1, 90};
    quickSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
}

public static void quickSort(int[] array, int beginIndex, int endIndex) {
    // System.out.println("called quick sort on the following : " + beginIndex + " " + endIndex);
    int arrayLength = endIndex - beginIndex + 1;
    int pivot = array[endIndex];
    if (arrayLength > 1) {
        int left = beginIndex;
        int right = endIndex - 1;
        while (left <= right) {
            // System.out.println(left + " " + right);
            while (left <= endIndex && array[left] < pivot) {
                left++;
            }
            while (right >= beginIndex && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                right--;
                left++;
            }

        }
        swap(array, left, endIndex); // this is crucial, and you missed it
        if (beginIndex < right) {
            quickSort(array, beginIndex, right);
        }
        if (left + 1 < endIndex) {
            quickSort(array, left + 1, endIndex);
        }
    }

}

private static void swap(int[] array, int index1, int index2) {
    int aux = array[index1];
    array[index1] = array[index2];
    array[index2] = aux;
}