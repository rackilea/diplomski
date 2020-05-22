private Integer minimax(Board board, Integer depth, Boolean maximizingPlayer, 
                        Integer maxPlayerBestVal, Integer minPlayerBestVal) {
    Integer bestValue;
    if (0 == depth)
        return this.evaluateBoard(board);

    Integer val;
    if (maximizingPlayer) {
        bestValue = -INF;
        // current never changed in your case; so you better use the bool
        for (Move m : board.getPossibleMoves(maximizingPlayer))) {
            board.apply(m);
            val = minimax(board, depth - 1, Boolean.FALSE, 
                          minPlayerBestVal, maxPlayerBestVal); // swap here 
            bestValue = Math.max(bestValue, val);
            board.revert(m);
            if (bestValue >= minPlayerBestVal) // too good for the minPlayer
                return bestValue;              // so cut here (pruning)
        }
        return bestValue;