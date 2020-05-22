public static boolean subArrayAppearsAt(int[] largeArray, int[] subArray, int i)
{
    if (subArray[0] == largeArray[i])
    {
        for (int j = 1; j < subArray.length; j++)
        {
            if (subArray[j] != largeArray[i+j])
            {
                return false;
            }
        }
        return true;
    }
    return false;
}