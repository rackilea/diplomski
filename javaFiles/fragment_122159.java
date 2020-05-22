int lowerBound(int[] array,int lo, int hi, int key)
{
    int low = lo-1, high = hi;
    while (low+1 != high)
    {
        int mid = (low+high)>>>1;
        if (array[mid]< key) low=mid;
        else high=mid;
    }
    int p = high;
    if ( p >= hi || array[p] != key )
        p=-1;//no key found
    return p;
}