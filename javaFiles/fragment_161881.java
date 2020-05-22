boolean isFullyConnected(int[][]m)
    for (int i = 0; i < m.length; i++) //iterate over rows
        for (int j = 0; j < m[i].length; j++) //iterate over columns
            if(i != j && m[i][j] == 0) //if not in main diag. and not connected
                return false;
    return true;
}