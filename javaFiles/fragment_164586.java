for(int cnt = 0; cnt < numSteps; cnt++)
{
    correct[x][y] = '*';
    if(x-1 >= 0 && maze[x-1][y] == maze[x][y]-1)
        x--;
    else if(x+1 < maze.length && maze[x+1][y] == maze[x][y]-1)
        x++;
    else if(y-1 >= 0 && maze[x][y-1] == maze[x][y]-1)
        y--;
    else if(y+1 < maze.length && maze[x][y+1] == maze[x][y]-1)
        y++;
}