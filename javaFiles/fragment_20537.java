// Start with the first row:
arr.pos(0, 0);

for (int row = 0; row < rows; row++) {
    double sum = 0;
    for (int col = 0; col < cols; col++)
        sum += arr.get(); // Relative get to calculate row sum

    // Now set the sum to the end of row.
    // For this we have to position back, so we use the absolute set.
    arr.set(row, cols - 1, sum);

    // The absolute set method also moves the pointer, and since
    // it is the end of row, it moves to the first of the next row.
}