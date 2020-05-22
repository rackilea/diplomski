for (int row = 0; row < (array.Length / 10); row++)
{
    for (int col = 0; col < 5; col++)
    {
        int rowStart = row * 10;
        int rowEnd = rowStart + 9;
        char temp = array[rowStart + col];                    
        array[rowStart + col] = array[rowEnd - col];
        array[rowEnd - col] = temp;
    }
}