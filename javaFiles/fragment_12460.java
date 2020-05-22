int[][] matrix = new int[dim][dim];

for(int i=0;i<matrix.length;i++)
{
    for(int j=0;j<matrix.length;j++)
    {
        // Figure out distance from i -> j
        matrix[i][j] = Math.abs(i - j) + 1;   
    }
}