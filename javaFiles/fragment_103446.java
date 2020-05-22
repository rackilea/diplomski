public static boolean colCheck(int choice, int currentTurn) {
    int row = -1;
    for (int r = 5; r >= 0; r--) {
        if (numBoard[r][choice] == 0) {
            row = r;
            break;
        }
    }
    // System.out.println("Row That CPU Chooses: " + row);
    if (row > -1) {
        numBoard[row][choice] = currentTurn;
        if (row == 0) {
            btnArray[choice].setEnabled(false);
            System.out.printf("debug 1 row %d %n", row);
            return false;
        }
        System.out.printf("debug 2 row %d %n", row);
        return true;
    }
    System.out.printf("debug 3 row %d %n", row);
    return false;
}