//Find value of Max and index of Max
    for (int i : arr)
    {
        if (i >= max)
        {
            max=arr[i-1];
            indexMax=i-1;
        } 
    }