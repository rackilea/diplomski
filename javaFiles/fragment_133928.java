private static final HashSet<Integer> BLOCKED_TILES = new HashSet<Integer>();
static {
  BLOCKED_TILES.add(24);
  BLOCKED_TILES.add(1);
  //add more tiles here
}

public boolean blocked(int tx, int ty) {
  return BLOCKED_TILES.contains(board[ty][tx]);
}