private int binarySearchRecursive(int first, int last, T desiredItem) 
{
    int position = 0;
    int mid = (first + last) / 2;
    if (first > last)
        position =  -(last + 1);
    else if (desiredItem.equals(list[mid]))
        position = mid;
    else if (desiredItem.compareTo(list[mid]) < 0)
        position = binarySearchRecursive(first, mid -1, desiredItem);
    else 
        position = binarySearchRecursive(mid + 1, last, desiredItem);
    return position;
}