while (!mazeCompleted){

boolean moveRight = (x + 1 < mazeMatrix.length && maze.mazeMatrix[x+1][y] == 0 ? true : false);
boolean moveLeft = (x - 1 >= 0 && maze.mazeMatrix[x-1][y] == 0 ? true : false);
boolean moveUp = (y + 1 < mazeMatrix[x].length && maze.mazeMatrix[x][y+1] == 0 ? true : false);
boolean moveDown = (y - 1 >= 0 && maze.mazeMatrix[x][y-1] == 0 ? true : false);