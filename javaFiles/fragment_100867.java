static int split(int[] array, final int first, final int last) {
    int low = first;
    int high = last;

    int splitPoint = first;
    while (low < high) {
        while (array[high] > array[low] && high > low) {
            high--;
        }
        while (array[low] <= array[high] && high > low) {
            low++;
        }
        if (low < high) {
            int tmp = array[low];
            array[low] = array[high];
            array[high] = tmp;
            if (low == splitPoint) {
                low++;
                splitPoint = high;
            } else {
                high--;
                splitPoint = low;
            }
        }
    }
    return splitPoint;
}