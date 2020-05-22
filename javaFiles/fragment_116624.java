int i = 0;
int j = 0;
while (true) {
    System.out.println("" + array[i][j]);
    --i;
    ++j;
    if (i < 0) {
        if (j == numCols)
            break;
        i = Math.min(j, numRows - 1);
        j = Math.max(j - numCols + 2, 0); 
    } else if (j >= numCols) {
        if (i == numRows - 2)
            break;
        i = numRows - 1;
        j = Math.max(j + 2 - numCols + i, 0);
    }
}