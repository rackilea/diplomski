public Int2DArray(int[][] newArray )
{
    for ( int i = 0 ; i < array.length ; i++ )
    {
        array[i][i] = newArray[i][i];
    }
}