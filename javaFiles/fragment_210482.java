public void makeGrid(int size) {
      this.lines = size; // If you do not need lines anywhere else then it is redundant
      grid = new Cell[size][size];
      for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)    {
              grid[i][j] = new Cell();
            }
      }