public static int[] pad(int[] toPad, int length)
{
    int[] returnArray = new int[length];
    int i;
    for (i = 0; i < toPad.length; i++)
        returnArray[i] = toPad[i];
    for (int j = i; j < returnArray.length; j++)
        returnArray[j] = 0;
    return returnArray;
}