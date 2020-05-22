public void isDraw(){
  for ( int row = 0; row < ROWS; row++) {
    for (int col = 0; col < COLUMNS; col++) {
      if (board[row][col] == ' ') {
        currentState = "Play";
        break;
      } else {
        currentState = "Draw"; // no empty cell, it's a draw
      } 
    }
  }
}