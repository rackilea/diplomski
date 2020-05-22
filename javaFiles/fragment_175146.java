private Object[] insertionSort(Object[] v, int vSize)
{
    for(int i = 0; i < vSize; i++)
    {
        Comparable temp = ((Pair)v[i]).getName();
        int j;

        for(j = i; j > 0 && temp.compareTo(((Pair)v[j - 1]).getName()) < 0; j--)
            v[j] = v[j - 1];

        v[j] = temp;
    }

    return v;
}