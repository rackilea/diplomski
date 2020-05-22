for (int num = 0; num < maxX*maxY; ++num) { // num - element number
    // calc element coordinates
    int y = num / maxX;
    int x = num % maxX;
    if (y % 2 == 1)
       x = maxX - x;
    int elem = matrix[x][y];
    // process element
}