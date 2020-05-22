for (int x = 0; x < gameboard.length; x++) {
     gameboard[0][x] = 1;
     gameboard[11][x] = 1;
     gameboard[x][0] = 1;
     gameboard[x][11] = 1;
}