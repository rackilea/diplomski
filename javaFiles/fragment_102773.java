int count = size;
while (count > 0)
{
    int save = arr[0];      // save the largest item
    arr[0] = arr[count-1];  // move last item to top
    arr[count-1] = save;    // and place the largest item
    count = count - 1;      // reduce the count
    SiftDown(0);            // sift item into place
}