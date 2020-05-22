int[10] oneDim = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int rows = 2;
int columns = 5;
for(int index = 0; index < 10; index++) {
    int column = index % columns;
    int row = (index - column) / columns;
    System.out.println(row + ", " + column + ": " + oneDim[index]);
}