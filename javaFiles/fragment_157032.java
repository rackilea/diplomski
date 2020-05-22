for( i = 0;i < rows;i++)
{
    int rowsum=0;
    for( j = 0;j < cols;j++)
    {
    rowsum += matrix[i][j];
    matrix[rows][j] += matrix[i][j];
    }
    matrix[i][j] = rowsum;
    grandtotal += rowsum;        
}