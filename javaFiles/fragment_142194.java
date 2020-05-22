int offsetX = 30;
int offsetY = 30;
for (int x = 0; x < pattern.length; x++)
  for (int y = 0; y < pattern[x].length; y++)
    if (pattern[x][y] == 1) {
      board[x + offsetX][y + offsetY].setNextState(true);
    } else {
      board[x + offsetX][y + offsetY].setNextState(false);
    }
    gc.setFill(board[x + offsetX][y + offsetY].getState() ? Color.rgb(244, 92, 66) : Color.LIGHTGRAY);
    gc.fillRect((x + offsetX) * 10, (y + offsetY) * 10, 9, 9);
  }
}