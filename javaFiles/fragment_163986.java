for (int i = 0; i < totalRows; i++)
{
    for (int j = 0; j < totalColumns; j++)
    {
        rowTotal[i] += numbers[i * totalColumns + j];
        blockTotal[j] += numbers[i * totalColumns + j];
    }            
}