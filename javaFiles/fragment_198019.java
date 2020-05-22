int count = 0;
int x = 4;
int y = 4; // arrays are 0 based
while(true)
{
    int random =  (int)Math.random()*4+1;
    if (random == 1)
    {
        x--; // move left
    }
    else if (random == 2)
    {
        x++; // move right
    }
    else if (random == 3)
    {
        y--; // move down
    }
    else if (random == 4)
    {
        y++; // move up
    }
    if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length) break;
    count++;
    grid[x][y]++;
}
System.out.println(count); // number of moves before it fell