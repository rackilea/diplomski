int[] neighbors = new int[8];//We know there will be 8 neighbors in a square
int neighborCount = 0;

for (int j = y-1; j <= y+1; j++)
{
    for (int i = x-1; i <= x+1; i++) // We start at the number 2(position [0][1]), increment through 3, and 4, then go to next row and start at 2 again.
    {
        if (! (j == y && i == x)) //Don't want to include 8 itself.
        {
            neighbors[neighborCount] = values[i][j];
            neighborCount++;
        }
    }
}