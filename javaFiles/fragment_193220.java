for(int h=0; h<length; h++)
{
    count = 1; // for the element at arr[h]
    for(int l=h + 1; l<length; l++)
    {
        if(arr[h] == arr[l])
        {
            count++;
        }
    }
    if(count > max)
    {
        max = count;
        maxnum = arr[h];
    }
}