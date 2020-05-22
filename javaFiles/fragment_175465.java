public static boolean checkPositionRow(char[][] a, int row, int col, int l) {
    int counter = 1; //starting from 1, because for a[row][col] itself
    char charAtPosition = a[row][col];
   //expand to the right as much as possible
    for (int i = col+1; i < a[row].length && a[row][i] == charAtPosition; i++) counter++;
   //expand to the left as much as possible
    for (int i = col-1; i >= 0 && a[row][i] == charAtPosition; i--) counter++;
    return counter >= l;
}