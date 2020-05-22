if(north(maze, x , y) == true)
    {
        maze[y-1][x] = 4;
        display(maze);

        //temp.y--;
        if (traverse(maze, x , y-1) == false)
        {
            maze[y][x] = 3;

        }
    }