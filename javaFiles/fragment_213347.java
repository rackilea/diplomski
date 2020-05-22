int perTotal = 0;
// top and bottom row
for (int c = 0; c < numCols; c++)
    perTotal += matrix[0][c] + matrix[numRows-1][c];
// left and right column
for (int r = 1; r < numRows-1; r++)
    perTotal += matrix[r][0] + matrix[r][numCols-1];

// output
System.out.println("Perimeter=" + perTotal);