static int count_elem(int arr[], int elem) {
    int rows = (int) Math.sqrt(arr.length);
    int cols = (int) Math.sqrt(arr.length);

    int midCol = cols / 2, colLen = rows, count = 0;
    for (int j = 0; j < rows; j++) {
        for (int i = 0; i < colLen; i++) {
            if (arr[j + (i * rows)] == elem) count++;
        }
        if (j < midCol) colLen--;
        else colLen++;
    }
    return count;
}