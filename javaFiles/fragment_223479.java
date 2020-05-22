public Piece[][] solve(int r, int c, List<Piece> piecesLeft) {
    // Note that this check is equivalent to
    // 'have r and c gone past the last square on the board?'
    // or 'are there no pieces left?'
    if (isSolved())
        return board;

    // Try each remaining piece in this square
    for (Piece p : piecesLeft) {
        // in each rotation
        for(int orientation = 0; orientation < 4; ++orientation) {
            if (tryInsert(p, r, c, orientation)) {
                // It fits: recurse to try the next square
                // Create the new list of pieces left
                List<Piece> piecesLeft2 = new ArrayList<Piece>(piecesLeft);
                piecesLeft2.remove(p);
                // (can stop here and return success if piecesLeft2 is empty)
                // Find the next point
                Point next = nextLoc(r, c);
                // (could also stop here if this is past end of board)

                // Recurse to try next square
                Piece[][] solution = solve(next.x, next.y, piecesLeft2);
                if (solution != null) {
                    // This sequence worked - success!
                    return solution;
                }
            }
        }
    }

    // no solution with this piece
    return null;
}