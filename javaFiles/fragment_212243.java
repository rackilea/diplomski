int count = array.length-1;
while (count > 0)
{
    swap(array[0], array[count]);
    --count;
    siftDown(0);
}