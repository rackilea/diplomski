findStartIndex(int[] A, int num)
{
    int start = 0; end = A.length-1;

    while (end != start) 
    {
        mid = (end - start)/2;

        if (A[mid] >= num)
            end = mid;
        else
            start = mid;
    }

    if(A[start] == num) 
        return start;
    else 
        return start+1;
}

findEndIndex(int[] A, int num)
{
    int start = 0; end = A.length-1;

    while (end != start) 
    {
        mid = (end - start)/2;

        if (A[mid] > num)
            end = mid;
        else
            start = mid;
    }

    if(A[start] == num) 
        return start;
    else 
        return start-1;
}