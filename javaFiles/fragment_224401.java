// Columns, Rows
Mines[][] mineGrid;

// Add stuff to the `mineGrid` array

// Set the height to the number of rows, length to number of columns
setLayout(new GridLayout(mineGrid.length, mineGrid[0].length);
// For each row
for(int rowIndex = 0; rowIndex < mineGrid.length; rowIndex++) {
    // For each column
    for(int colIndex = 0; colIndex < mineGrid[0].length; colIndex++) {
        // Add the button, because of GridLayout it starts @ the top row, goes across left to right, down a row, across left to right, etc.
        add(mineGrid[rowIndex][colIndex];
    }
}