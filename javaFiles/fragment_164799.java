//returns a collection of all cells that are bounded by the path 
    //and their token is of the opposite color of the path 
    List<int[]> getContainedWithin() {

        //find path max and min X values, max and min Y values
        minPathRow = grid[0].length; //set min to the largest possible value
        maxPathCol = grid.length;
        maxPathRow = 0;              //set max to the largest possible value
        maxPathCol = 0;

        //find the actual min max x y values of the path
        for (int[] cell : this) {
            minPathRow = Math.min(minPathRow, cell[0]);
            minPathCol = Math.min(minPathCol, cell[1]);
            maxPathRow = Math.max(maxPathRow, cell[0]);
            maxPathCol = Math.max(maxPathCol, cell[1]);
        }

        //todo remove after testing
        System.out.println("x range: "+minPathRow + "-" 
        + maxPathRow + " y range: " + minPathCol + "-" + maxPathCol);

        List<int[]> block = new ArrayList<>(25);
        int[] cell = get(0);//get an arbitrary cell in the path
        Token pathToken = grid[cell[0]][cell[1]]; //keep a reference to its token

        //iterate over all cells within path x, y limits
        for (int col = minPathCol; col < (maxPathCol); col++) {

            for (int row = minPathRow; row < (maxPathRow); row++) {

                //check cell color
                Token token = grid[row][col];
                if ((token == pathToken) || (token == Token.VIDE)) {
                    continue;
                }
                if (isWithinLoop(row,col)) {
                    block.add(new int[] {row, col});
                }
            }
        }

        return block;
    }

    //check if row, col represent a cell with in path by checking if it has a 
    //path-cell to its left, right, top and bottom 
    private boolean isWithinLoop(int row, int col) {

        if(  isPathCellOnLeft(row, col)
             &&
             isPathCellOnRight(row, col)
             &&
             isPathCellOnTop(row, col)
             &&
             isPathCellOnBottom(row, col)
          ) {
            return true;
        }

        return false;
    }

    private boolean isPathCellOnLeft(int cellRow, int cellCol) {

        for ( int col = minPathCol; col < cellCol ; col++) {

            if(getPath().contains(new int[] {cellRow, col})) {
                return true;
            }
        }

        return false;
    }

    private boolean isPathCellOnRight(int cellRow, int cellCol) {

        for ( int col = cellCol; col <= maxPathCol ; col++) {

            if(getPath().contains(new int[] {cellRow, col})) {
                return true;
            }
        }

        return false;
    }

    private boolean isPathCellOnTop(int cellRow, int cellCol) {

        for ( int row =minPathRow; row < cellRow ; row++) {

            if(getPath().contains(new int[] {row, cellCol})) {
                return true;
            }
        }

        return false;
    }

    private boolean isPathCellOnBottom(int cellRow, int cellCol) {

        for ( int row = cellRow; row <= maxPathRow; row++) {

            if(getPath().contains(new int[] {row, cellCol})) {
                return true;
            }
        }

        return false;
    }
}