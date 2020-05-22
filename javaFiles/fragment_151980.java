public static boolean isRow(int row, double[][] array)
{
    boolean flag = false;

    if (array != null && row >= 0 && row < array.length)
    {
        if ( array[row] != null )
        {
            flag = true;
        }
    }
    return flag;
}