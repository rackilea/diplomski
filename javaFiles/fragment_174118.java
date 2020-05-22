/**
 * This function simply gets the number of neighbors for each cell, and saves the future generation
 * based on the number neighbors from arr to future array.
 * 
 * @param arr Arr that will be checked for neighbors
 * @param futureGen This array will keep track of the future generation
 * @param columns numbers of columns
 * @param rows numbers of rows
 */
public void checkN(Cell [][] arr, Cell [][] futureGen, int columns, int rows) {
    for (int x = 0; x < rows; x++) {
        for (int y = 0; y < columns; y++) {               
            arr[x][y].setNeighbors(0);

            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    if(i == 0 && j == 0) continue; //don't check self
                    if(x + i < 0 || x + i >= rows) continue; //bounds checking
                    if(y + j < 0 || y + j >= columns) continue; //bounds checking

                    if (arr[x + i][y + j].getLife() == 1)
                            arr[x][y].addNeighbor();
                }
            }

            // Get the new generation through the neighbors
            if(arr[x][y].getLife() == 1 &&
                (arr[x][y].getNeighbors() == 2 || arr[x][y].getNeighbors() == 3))
                futureGen[x][y].setLife(1);
            else if(arr[x][y].getLife() == 0 && arr[x][y].getNeighbors() == 3)
                futureGen[x][y].setLife(1);
            else
                futureGen[x][y].setLife(0);               
        }
    }
}