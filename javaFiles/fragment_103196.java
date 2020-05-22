public boolean isLegalMove(Location from,Location to)
{
  // Row is XPosition (Up/Down)
  // Column is YPosition(Left/Right)

  int fromRow = from.getXPosition();
  int fromColumn = from.getYPosition();
  int toRow = to.getXPosition();
  int toColumn = to.getYPosition();

  // Has to be same row or column
  if(fromRow != toRow || fromColumn != toColumn) return false;
  // Can't move to the same square
  if(fromRow == toRow && fromColumn == toColumn) return false;

  // Rows are the same
  if(fromRow - toRow == 0) {
    // this will hold the column of the we're going to check next
    int newPos = fromColumn;
    // Should we go up or down?
    int amount = (toColumn - fromColumn < 0) ? -1 : 1;
    while(newPos != toColumn) {
      newPos += amount;
      // if it's not null, we found a different piece
      if(gameBoard[fromRow][newPos] != null) return false;
    }
    if(gameBoard[toRow][toColumn] != null) {
      // return false if it's your own piece, true if it's not
    }
  // Columns are the same
  } else {
    // this will hold the row of the we're going to check next
    int newPos = fromRow;
    // Should we go up or down?
    int amount = (toRow - fromRow < 0) ? -1 : 1;
    while(newPos != toRow) {
      newPos += amount;
      // if it's not null, we found a different piece
      if(gameBoard[newPos][fromColumn] != null) return false;
    }
    if(gameBoard[toRow][toColumn] != null) {
      // return false if it's your own piece, true if it's not
    }
  }

  return true;
}