public char getWithDefault(int row, int col, char default ) {
  if ((0 <= row) && ( row < board.length) &&
      (0<=col) && (col < board[row].length)) {
    return board[row][col];
  }
  return default;
}

public boolean isDiagonal(int row,int col){
  // arbitrary default value, as long as it is != 'T'
  if (getWithDefault(row,col,'1') != 'T') return false;
  if (getWithDefault(row+1,col+1,'1') == 'T') return true;
  if (getWithDefault(row+1,col-1,'1') == 'T') return true;
  if (getWithDefault(row-1,col+1,'1') == 'T') return true;
  if (getWithDefault(row-1,col-1,'1') == 'T') return true;
  return false;
}