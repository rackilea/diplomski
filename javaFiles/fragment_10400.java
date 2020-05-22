int SortedArray[max] = {....}

int BinarySearch (int key)
{
    int start = 0;
    int end = max - 1;
    int mid;
    while (start <= end)
    {
        mid = (start + end) / 2;
        if (key == a[mid])
            return mid;
        else if (key < a[mid])
            end = mid - 1;
        else start = mid + 1;
    }
    return -1;
}