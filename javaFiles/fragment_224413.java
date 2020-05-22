private boolean isWithinBoardAndFree(Point point, Figure[][] board){
    if (point.x >= 0 && point.x >= 0)
    {
    if (board[point.x][point.y] == null)
        {
            return true;    
        }
    }
        return false;
}