int num=1;
    while (num < limit)
    {
        s=Integer.toString(num);
        if (isIncreasing(s) || isDecreasing(s))
        {
        }
        else
        {
            count++;
        }
        num++;
    }