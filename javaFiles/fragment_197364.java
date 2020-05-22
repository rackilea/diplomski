private static enum Direction{
    UP,
    RIGHT,
    DOWN,
    LEFT,
    NONE;
}

public static boolean checkIfPositionIsInLoop(int[][] matrix, int x, int y, int fillValue){
    int targetX = x;
    int targetY = y;
    return fillReachesTargetPosition(matrix, x, y, targetX, targetY, fillValue, Direction.LEFT /*don't allow it to start filling to the left*/);
}

private static boolean fillReachesTargetPosition(int[][] matrix, int x, int y, int targetX, int targetY,  int fillValue, Direction forbiddenDirection) {

    if (x>=matrix.length)
      return false;
    if (y>=matrix[x].length)
      return false;

    int originValue=matrix[x][y];
    matrix[x][y]=fillValue;

    int xToFillNext;
    int yToFillNext;

    boolean fillingReachedTargetPosition = false;

    // Up
    xToFillNext = x-1;
    yToFillNext = y;
    if(xToFillNext==targetX && yToFillNext==targetY && !forbiddenDirection.equals(Direction.UP)){
        return true;
    } else if (xToFillNext>=0 && originValue==matrix[xToFillNext][yToFillNext] && !forbiddenDirection.equals(Direction.UP)){            
        fillingReachedTargetPosition = 
                fillReachesTargetPosition(matrix, xToFillNext, yToFillNext, targetX, targetY, fillValue,Direction.DOWN /*Just came from up- don't allow it to try filling here again*/);
        if(fillingReachedTargetPosition){
            return true;
        }
    }

    // Right
    xToFillNext = x;
    yToFillNext = y+1;
    if(xToFillNext==targetX  && yToFillNext==targetY && !forbiddenDirection.equals(Direction.RIGHT)){
        return true;
    } else if (yToFillNext<matrix[xToFillNext].length && originValue==matrix[xToFillNext][yToFillNext] && !forbiddenDirection.equals(Direction.RIGHT)) {
      fillingReachedTargetPosition = 
        fillReachesTargetPosition(matrix, xToFillNext, yToFillNext,targetX, targetY, fillValue,Direction.LEFT /*Just came from right- don't allow it to try filling here again*/);
      if(fillingReachedTargetPosition){
          return true;
      }
    }

    // Down
    xToFillNext = x+1;
    yToFillNext = y;
    if(xToFillNext==targetX && yToFillNext==targetY && !forbiddenDirection.equals(Direction.DOWN)){
        return true;
    } else if (xToFillNext<matrix.length  && originValue==matrix[xToFillNext][yToFillNext] && !forbiddenDirection.equals(Direction.DOWN)){
        fillingReachedTargetPosition = 
                fillReachesTargetPosition(matrix, xToFillNext, yToFillNext, targetX, targetY, fillValue,Direction.UP /*Just came from up- don't allow it to try filling here again*/);  
        if(fillingReachedTargetPosition){
              return true;
        }
    }

    // Left
    xToFillNext = x;
    yToFillNext = y-1;
    if(xToFillNext==targetX && yToFillNext==targetY && forbiddenDirection.equals(Direction.RIGHT)){
        return true;
    } else if (yToFillNext>=0 && originValue==matrix[xToFillNext][yToFillNext] && !forbiddenDirection.equals(Direction.LEFT)){
        fillingReachedTargetPosition = 
                fillReachesTargetPosition(matrix, xToFillNext, yToFillNext, targetX, targetY, fillValue,Direction.RIGHT /*Just came from left- don't allow it to try filling here again*/);
        if(fillingReachedTargetPosition){
            return true;
        }
    }

    return false;
  }