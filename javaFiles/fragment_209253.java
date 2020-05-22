private static <T extends Comparable<T>> int partition(T[] array, int min, int max) {
    int left, right;
    T pivot, temp;
    int middle = (min+max)/2;

    left  = min + 1;
    right = max ;
    pivot = array[middle];

    // move partition element to min index
    temp = array[min];
    array[min] = array[middle];
    array[middle] = temp;

    while (left < right) {

        while (array[left].compareTo(pivot) <= 0 && left < right)
            left++; 

        while (array[right].compareTo(pivot) > 0)
            right--;

        if (left<right) {
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }

    }

    // move partition element to partition index
    temp = array[min];
    array[min] = array[right];
    array[right] = temp;
    return right;
}