public static boolean hasDuplicates(int[] array)
{
    for (int i = 0, length = array.length; i < length; i++)
    {
        int val = array[i];
        for (int j = 0; j < i; j++)
        {
            if (array[j] == val)
            {
                return true;
            }
        }
    }

    return false;
}