public int sumRow(int[][] matrix, int row)
{
    int sum = 0;
    for(int i = 0; i < matrix[row].length; i++)
    {
        sum += matrix[row][i];
    }
    return sum;
}