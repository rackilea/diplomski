class Position {
  int x, int y;
}

class Piece
{
  Side side; // which side the piece is
}

class Board
{
  HashMap<Piece, Position> board;

  boolean isMoveLegal(Piece p, Position newPosition) {
    ...
  }

  void doMove(Piece p, Position newPosition) {
    if (isMoveLegal(p, newPosition) {
      // game logic of movement and eating other pieces if needed
    }
  }
}