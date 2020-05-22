public boolean[] getPossible( int i, int j)
   {

    boolean[] possibleArray = new boolean[10];
    if (game[i][j] == 0)
    {
        for( int b=1; b < 10; b++)
        {
            possibleArray[b] = true;
        }

        for (int n = 1; n < GRID_SIZE; ++n) {
            possibleArray[game[i][n]] = possibleArray[game[n][j]] = false;
        }
        // TODO Scan the 3x3 square containing cell (i,j)
        possibleArray[0]= true;
    }
    return possibleArray;
}