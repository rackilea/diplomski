private void countNeighbors(Cell[][] arr, int row, int column, int rows, int columns) {
    Cell c = arr[row][column];
    c.setNeighbors(0);

    for(int i = -1; i <= 1; i++) {
        for(int j = -1; j <= 1; j++) {
            if(i == 0 && j == 0) continue; //don't check self
            if(row + i < 0 || row + i >= rows) continue; //bounds checking
            if(column + j < 0 || column + j >= columns) continue; //bounds checking

            if (arr[row + i][column + j].getLife() == 1)
                    c.addNeighbor();
        }
    }
}

private void evaluateNeighbors(Cell oldCell, Cell newCell) {
    if (oldCell.getLife() == 1 &&
        (oldCell.getNeighbors() == 2 || oldCell.getNeighbors() == 3))
        newCell.setLife(1);
    else if(oldCell.getLife() == 0 && oldCell.getNeighbors() == 3)
        newCell.setLife(1);
    else
        newCell.setLife(0);
}

public void checkN(Cell [][] arr, Cell [][] futureGen, int columns, int rows) {
    for (int row = 0; row < rows; row++) {
        for (int column = 0; column < columns; column++) {               
            countNeighbors(arr, row, column, rows, columns);

            evaluateNeighbors(arr[row][column], futureGen[row][column]);            
        }
    }
}