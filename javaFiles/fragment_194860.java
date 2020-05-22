static int[] sort(int[] array) {
    final int size = array.length;

    final int[] result = new int[size];
    for (int i = 0; i < size; i++)
        result[i] = i;

    boolean sorted;
    do {
        sorted = true;
        int bubble = result[0];
        for (int i = 0; i < size - 1; i++) {
            if (array[bubble] > array[result[i + 1]]) {
                result[i] = result[i + 1];
                result[i + 1] = bubble;
                sorted = false;
            } else {
                bubble = result[i + 1];
            }
        }
    } while (!sorted);

    return result;
}

result arrays for your input data is [6, 9, 0, 4, 8, 7, 1, 3, 5, 2]