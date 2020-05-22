// Get the maximum number of columns among all rows.
int maximumColumns = 0;
for (double[] row : multi) {
    if (row.length > maximumColumns) {
        maximumColumns = row.length;
    }
}

for (int column = 0; column < maximumColumns ; column++) {
    for (int row = 0; row < multi.length; row++) {
        if (column >= multi[row].length) {
            // There is no value for this column.
        } else {
            // Do stuff here with multi[row][column].
        }
    }
}