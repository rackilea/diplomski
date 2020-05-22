public static void insertionSort(Comparable[] item, int size) {
    // Changed to k >= 0, otherwise we would have ignored the 0th
    // element and not move it to higher positions in the array
    for (int k = size - 1; k >= 0; k--)
        insertInOrder(item, k, size);
}

// Added size as a parameter
private static void insertInOrder(Comparable[] item, int m, int size) {
    Comparable save = item[m];
    // This loop needs to count upward, because you
    // want to move large values towards the back
    for (; m + 1 < size && item[m+1].compareTo(save) < 0; m++)
        item[m] = item[m + 1];
    item[m] = save;
}