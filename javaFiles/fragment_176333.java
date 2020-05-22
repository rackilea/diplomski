bestMove = function(Board board, piece piece, int lookAhead)
{
 possibleMoves = getPossibleMoves(board, piece)
 bestMove = null
 bestScore = -INFINITY
 boardCp = clone(board)     

 for (move in possibleMoves)
 {
    /* just the original code */
     if(lookAhead <= 1) {
         tempBoard = applyMove(boardCp, move)
         if (tempBoard.score > bestScore)
         {
             bestMove = move
             bestScore = tempBoard.score
          }
         boardCp = undoMove(tempBoard, move)
     }

     /* recursion, can be changed to a loop */
     else {
        tempBoard = applyMove(boardCp, move)                // apply
        move2 = bestMove(tempBoard, piece, lookAhead-1)     // dive and get best 
        boardCp = undoMove(tempBoard, move)                 // (1) check how good it actually is
        tempBoard = applyMove(boardCp, move2)
        if (tempBoard.score > bestScore)
         {
             bestMove = move2
             bestScore = tempBoard.score
          }
        boardCp = undoMove(tempBoard, move2)                // generaly I'd refactor both if-else paths and reuse some code
     }
  }

return bestMove
}