public void sort()
{
    for (out = nElems-1 ; out >= 1 ; out--)
    {
        for (in = 0 ; in < out ; in++)
        {
            comparisons = comparisons+1;
            if ((a.get(in)) > (a.get(in+1)))
            {
                swap (in, in+1);
                assignments = assignments+2;
            }
        }
    }
}