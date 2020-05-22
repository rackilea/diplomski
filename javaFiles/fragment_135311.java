filled=0;
for (int i = x - 1; i < x + 2; i++)
{
    for (int j = y - 1; j < y + 2; j++) 
    {
        if(i<0 || i>=rows || j<0 || j>=columns || i==x || j==y)
               continue;

        filled = integerGeneration[i][j] + filled;
    }
}
return filled;