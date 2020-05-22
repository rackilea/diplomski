public static void sortArray (ArrayList<Integer> arrayToSort)
{
    int smallestNum;
    int smallestPos;

    for (int j=0; j<arrayToSort.size(); j++)
    {
        smallestNum = arrayToSort.get(j);
        smallestPos = j;
        for (int i=j; i<arrayToSort.size(); i++)
        {
            if (arrayToSort.get(i)<=smallestNum)
            {
                smallestNum = arrayToSort.get(i);
                smallestPos = i;
            }
        }
        arrayToSort.set(smallestPos, arrayToSort.get(j);
        arrayToSort.set(j, smallestNum);
    }       
}