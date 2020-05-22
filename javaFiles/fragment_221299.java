// check move legality not taking into account blocking
  boolean canMoveBishopTo(int srcx,int srcY,int destX,int destY) {
      if (srcX<0 || srcX>7 ||srcY<0 || srcY>7 || destX<0 || destX>7 ||destY<0 || destY>7) {
        throw new IllegalArgumentException();
      }
      if ((srcX==destX || srcY==destY) {
        return false;
      }

      if (Math.abs(destX-srcX) == Math.abs(srcY-destY) {
        return true;
      }
      return false;
    }

boolean isBishopMoveBlocked(int srcx,int srcY,int destX,int destY) {
  // assume we have already done the tests above
  int dirX = destX>srcX ? 1 : -1;
  int dirY = destY>srcY ? 1 : -1;
  for (int i=1;i<Math.abs(destX-srcX)-1;++i) {
    if (pieceOnSquare(srcX+i*dirX,srcY+i*dirY) {
      return false;
    }
  }
  return true;
}