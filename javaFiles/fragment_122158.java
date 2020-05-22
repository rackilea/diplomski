int upperBound(int[] array,int lo, int hi, int key)
{
    int low = lo-1, high = hi;
    while (low+1 != high)
    {
        int mid = (low+high)>>>1;
        if (array[mid]> key) high=mid;
        else low=mid;
    }
    int p = low;
    if ( p >= hi || array[p] != key )
        p=-1;//no key found
    return p;
}