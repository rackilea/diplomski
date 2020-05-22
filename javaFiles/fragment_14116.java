private int countCells(Cell c, int gen, Filter filter)
{
    int x = c.getX();
    int y = c.getY();
    CellState state;
    int counter = 0;
    for (int i = x - 1; i <= x + 1; i++) 
    {
        for (int j = y - 1; j <= y + 1; j++) 
        {
            if (i == x && j == y)
                continue;
            state = getCell(i, j).getCellState(gen);
            if (filter.countMeIn(state))
            {
                counter++;
            }
        }
    }
    return counter;
 }

 private interface Filter
 {
      boolean countMeIn(State state);
 }

 public int calculateNumOfDeadNeighbors(Cell c, int gen)
 {
     return countCells(c, gen, new Filter()
                       { 
                           public boolean countMeIn(CellState  state)
                           {
                              return (state == CellState.DEAD || state == CellState.DEAD4GOOD);
                           }
                        });
  }

 public int calculateNumOfLiveNeighbors(Cell c, int gen)
 {
     return countCells(c, gen, new Filter()
                       { 
                           public boolean countMeIn(CellState  state)
                           {
                              return (state == CellState.LIVE || state == CellState.SICK);
                           }
                        });
  }