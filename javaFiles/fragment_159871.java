int rows = readInt("rows");
int columns =readInt("columns");
int [][] m = new int[rows][columns];
for (int i = 0; i < rows; i++) {
    int n[]=readInts("enter 3 numbers:");
    for (int k = 0; k < columns; k++) {
        m[i][k] = n[k];
    }
}