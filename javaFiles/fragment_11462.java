public static int[] sortArray(int[] array) {

    int length = array.length;

    for (int i = 0; i < length - 1; i++) {
        int k = -1; // The index of last odd element
        for (int j = 0; j < length - i; j++)
            if (array[j] % 2 != 0) {
                if (k >= 0 && array[k] > array[j]) {
                    int temp = array[k];
                    array[k] = array[j];
                    array[j] = temp;
                }
                k = j;
            }
    }

    return array;
}