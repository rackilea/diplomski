public static boolean isVert(int[][] x) { //checks for more than one 1 in columns
    int count = 0;
    for (int i = 0; i < x.length; i++) {
        int rowCount = 0;
        for (int j = 0; j < x[i].length; j++) {
            if (x[i][j] == 1) {
                rowCount++;
            }
            if(rowCount > 1) {
                count++;
                break;
            }
        }
    }
    // returns true if count of lines containing 1 equals length of array, 
    // if not, returns false
    return count == x.length;
}