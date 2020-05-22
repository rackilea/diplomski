if (cell == aliveColor)
            {
                if (aliveNeighbors == 2 || aliveNeighbors == 3){
                    val =1;
                    grid.setPos(row,  column,val);
                }
                if (aliveNeighbors ==1 || aliveNeighbors == 4){
                    val = 0;
                    grid.setPos(row,column,val);
                }
            }