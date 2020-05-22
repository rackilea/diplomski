public static int[] stripped(int[] A)
{
    int[] count = new int[maximumValuePossible(A)];
    int uniques = 0;

    for (int i = 0; i < A.length; i++)
    {
        count[A[i]]++;
        if (count[A[i]] == 1)
        {
            uniques++;
        }
    }

    if (uniques == 0) return null;

    int[] retArray = new int[uniques];
    int retIndex = 0;
    for (int i = 0; i < count.length; i++)
    {
        if (count[i] > 0)
        {
            retArray[retIndex++] = count[i];
        }
    }

    return retArray;
}