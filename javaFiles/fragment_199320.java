private static <T extends Comparable<T>> int partition(T[] data,
        int min,
        int max) {
    T partitionelement;
    int left, right;
    int middle = (min + max) / 2;
    // use the middle data value as the
    // partition element
    partitionelement = data[middle];
    // move it out of the way for now
    swap(data, middle, min);
    left = min;
    right = max;
    while (left < right) {
        // search for an element that is >
        // the partition element
        while (left < right
                && data[left].compareTo(partitionelement) <= 0){
            // counts the number of comparisons in quick sort
            quickSortComparisons++;
            left++; // <--- this was not in the while loop
        }
        quickSortComparisons++; // <--- I believe you should have this one too
        // search for an element that is <
        // the partition element
        while (data[right].compareTo(partitionelement) > 0){
            // counts the number of comparisons in quick sort
            quickSortComparisons++;
            right--; // <--- this wasn't in the while loop neither
        }
        // counts the number of comparisons in quick sort
        quickSortComparisons++;
        // swap the elements
        if (left < right)
            quickSortComparisons++;// counts the number of comparisons in quick sort
        swap(data, left, right);
    }
    // move the partition element into place
    swap(data, min, right);
    return right;
}