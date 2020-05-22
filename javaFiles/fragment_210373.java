protected Vector<GameCell> findPath(int nRow, int nCol)
{
    this.aBoard[nRow][nCol].setVisited(true);        
    if(this.aBoard[nRow][nCol].getVal() == 'E')
    {
        Vector<GameCell> list = new Vector<GameCell>();
        list.add(this.aBoard[nRow][nCol]);
        return list;  
    }

    if(canGoUp(nRow, nCol))
    {
        if(!this.aBoard[nRow - 1][nCol].isVisited())
        {
            Vector<GameCell> list = findPath(nRow - 1, nCol);
            if(list != null)
            {
                list.add(this.aBoard[nRow][nCol]);
                return list;
            }
        }
    }

    if(canGoRight(nRow, nCol))
    {
        if(!this.aBoard[nRow][nCol+1].isVisited())
        {
            Vector<GameCell> list = findPath(nRow, nCol + 1);
            if(list != null)
            {
                list.add(this.aBoard[nRow][nCol]);
                return list;
            }
        }

    }

    if(canGoLeft(nRow, nCol))
    {
        if(!this.aBoard[nRow][nCol - 1].isVisited())
        {
            Vector<GameCell> list = findPath(nRow, nCol - 1);
            if(list != null)
            {
                list.add(this.aBoard[nRow][nCol]);
                return list;

            }
        }
    }

    if(canGoDown(nRow, nCol))
    {
        if(!this.aBoard[nRow + 1][nCol].isVisited())
        {
            Vector<GameCell> list = findPath(nRow + 1, nCol);
            if(list != null)
            {
                list.add(this.aBoard[nRow][nCol]);
                return list;
            }
        }
    }

    return null;

}