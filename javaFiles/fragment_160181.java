public boolean diagonal(char[ ][ ] theBoard, char thePlayer) {
    boolean result = false;
    int x; // This will tell you the coordinates of thePlayer if found on theBoard

    for(int i = 0; I < theBoard.length; i++)
        if (thePlayer == theBoard[i][i]) {
            result = true;
            // Add if you want to know coordinates of the player
            x = i;
       }

    return result;
}