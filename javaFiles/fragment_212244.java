void siftDown(int index)
{
    // Left child is at index*2+1. Right child is at index*2+2;
    while (true)
    {
        // first find the largest child
        int largestChild = index*2+1;
        // if left child is larger than count, then done
        if (largestChild >= count)
        {
            break;
        }
        // compare with right child
        if (largestChild+1 < count && array[largestChild] < array[largestChild+1])
        {
            ++largestChild;
        }

        // If item is smaller than the largest child, then swap and continue.
        if (array[index] < array[largestChild])
        {
            swap(array[index], array[largestChild]);
            index = largestChild;
        }
        else
        {
            break;
        }
}