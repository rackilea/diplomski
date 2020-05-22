public static void main(String[] args) {
    int[] array = {9, 7, 5, 8, 1, -5};
    System.out.println(Arrays.toString(sort(array)));
}

public static int[] sort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = i+1; j < n; j++) {
            if (array[i] > array[j]) {
                swapElementsInArray(array, i, j);
            }
        }
    }
    return array;
}

private static void swapElementsInArray(int[] array, int indexOfFirstElement, int indexOfSecondElement) {
    if (array[indexOfFirstElement] > array[indexOfSecondElement]) {
        int oldVal = array[indexOfFirstElement];
        array[indexOfFirstElement] = array[indexOfSecondElement];
        array[indexOfSecondElement] = oldVal;
    }
}