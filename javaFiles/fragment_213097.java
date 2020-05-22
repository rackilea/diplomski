int array[][] = new int[row][col];
// ... populate the array with random numbers, works fine...

// Let's traverse the first column.
for (int i = 0; i < row; i++) {
    int value = array[i][0]; // col 0 means first column
    if (value % 2 == 0) {
        // ...
    }
}

// Let's traverse the second column.
for (int i = 0; i < row; i++) {
    int value = array[i][1]; // col 1 means second column
    // ...
}