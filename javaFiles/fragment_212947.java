public Board(Board tempBoard){
    this.board = new char[tempBoard.board.length][tempBoard.board.length];
    this.robots = new  Point[tempBoard.robots.length];
    System.arraycopy( tempBoard.board, 0, board, 0, tempBoard.board.length );
    System.arraycopy( tempBoard.robots, 0, robots, 0, tempBoard.robots.length );
    this.size = tempBoard.size;
    this.goal = tempBoard.goal;
    this.moves = tempBoard.moves;
}