void sort()
{
    int temp = 0;
    for (out = 1 ; out < nElems ; out++)
    {
        count = count+1;
        temp[0] = a.get(out);
        in = out;
        comparisons = comparisons + 1; //You're doing the comparison below at least once
        while (in > 0 && a.get(in-1) >= temp[0])
        {
            a.set(in, a.get(in-1));
            --in;
            assignments = assignments+1;
            comparisons = comparisons + 1; 
        }
        a.set(in, temp[0]);
        assignments = assignments+1;
    }
}