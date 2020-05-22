public static boolean solve(char[][] maze, int row, int column)
{
      boolean success = false;

      if (maze[row][column] == 'f') //check for finish
        success = true;
      else if(valid(maze, row, column))
      {
         maze[row][column] = 'v';  //mark as visited

          success = solve(maze, row - 1, column);  //north
          if(!success)
             success = solve(maze, row, column + 1);  //west
          if(!success)
             success = solve(maze, row, column - 1);  //east
          if(!success)
             success = solve(maze, row + 1, column);  //south

         if(success)  //mark as path
            maze[row][column] = 'p';
      }
      return success;
}