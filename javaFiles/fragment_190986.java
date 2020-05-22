private static int[][] getSolution(int n) {
    if (n == 0) {
       return grid;        
    }//end if

    Cell cell = getNextEmpty();
    boolean fits = false;
    for (int i = 0; i <= 9; i++) {
        fits = insertNumber(cell, i);
        if (fits) {
            break; // means i fits in Cell
        } else {
            // i doesn't fit... try the next i
            // don't need to do anything
        }
    }//end for
    if (!fits) {
        // There are no numbers that fit in this Cell
        // What should happen?
        // Did I make a bad guess?
        // How do I BACKTRACK and correct a previous guess?
    }
    return getSolution(n - 1);
}//end getSolution