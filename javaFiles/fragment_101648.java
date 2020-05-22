try {

  int neighbors = 0;
  for (int i = -1; i <= 1; i++) {
    for (int j = -1; j <= 1; j++) {
      neighbors += currentBoard[x+i][y+j].state;
    }
  }
  if      ((state == 1) && (neighbors <  2))return new Cell(x, y, 0);
  else if ((state == 1) && (neighbors >  3))return new Cell(x, y, 0); 
  else if ((state == 0) && (neighbors == 3))return new Cell(x, y, 1); 
  else return new Cell(x, y, state);
}
catch(ArrayIndexOutOfBoundsException exception) {
  return new Cell(x, y, 0);
}