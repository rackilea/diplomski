static public int findIndexOfMax(int[] intList, int countOfInts)
{
    int largest = intList[0];
    for (int i = 1; i < intList.length; i++)
    {
        if (intList[i] > largest)
        {
            largest = intList[i];
        }
    }
    return largest; // <<== Here
}