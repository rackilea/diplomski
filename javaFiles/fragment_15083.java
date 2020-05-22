// Local variables inside a function
int[] wall = null;
if(row - 1 <= rows && labirinth[row-1][column] == "*")
{
    wall =  new int[2];
    wall[0] = row-1;
    wall[1] = column;
    walls.add(wall);
}
if(row + 1 <= rows && labirinth[row+1][column] == "*")
{
    wall = new int[2];
    wall[0] = row+1;
    wall[1] = column;
    walls.add(wall);
}
...