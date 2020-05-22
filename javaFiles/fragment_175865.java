int[10] oneDim = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int rows = 2;
int columns = 5;
for (int row = 0; row < rows; row++) {
    for (int column = 0; column < columns; column++) {
        System.out.println(row + ", " + column + ": " + oneDim[row * columns + column]);
    }
}