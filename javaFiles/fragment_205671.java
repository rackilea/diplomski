for (i = 0; i < arrTime.length - 1; i++) {
    boolean canMove = true;
    for (j = arrTime[i]; j < arrTime[i + 1] && canMove; j++) {
        if (arrDirection[i].equals("SE")) {
            if (nCurrRow < n - 1 && nCurrCol < n - 1 && cell[nCurrRow + 1][nCurrCol + 1] == 0) {
                nCurrRow++;
                nCurrCol++;
                cell[nCurrRow][nCurrCol] = 1;
            } else
                canMove = false;
        } else if (arrDirection[i].equals("NE")) {
            if (nCurrRow > 0 && nCurrCol < n - 1 && cell[nCurrRow - 1][nCurrCol + 1] == 0) {
                nCurrRow--;
                nCurrCol++;
                cell[nCurrRow][nCurrCol] = 1;
            } else
                canMove = false;
        } ...