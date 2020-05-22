public int array2D[10][15]; // 10 row and 15 col

public int getElementAt(int rowIndex, int colIndex)
{
    int ret;
    if( rowIndex >= 0 && rowIndex < array2D.length && colIndex >= 0 && colIndex < array2D[0].length )
    {
        ret = array2D[rowIndex][colIndex];
    }
    else
    {
        // Throw something according to what you want or exit or special return value
    }
    return ret;
}