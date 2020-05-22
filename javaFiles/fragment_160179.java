public boolean diagonal(char[ ][ ] theBoard, char thePlayer) {
    boolean result = false;
    int x, y; // These will tell you the coordinates of thePlayer if found on theBoard

    for(int i = 0; I < theBoard.length; i++)
        for(int j = 0; j < theBoard[i].length; j++)
            if (thePlayer == theBoard[i][j]) {
                result = true;
                // Add if you want to know coordinates of the player
                x = i;
                y = j;
           }

    return result;
}