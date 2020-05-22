public int findStart(int[] numbers) {
    int low = 0;
    int high = numbers.length; // Exclusive
    while (low < high) {
        int middle = (low + high) / 2;
        boolean fitsLow = numbers[low] <= numbers[middle];
        if (fitsLow) {
            low = middle + 1;
        } else {
            high = middle;
        }
    }
    return low;
}