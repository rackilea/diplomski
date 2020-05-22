void recursiveBitPatterns(ArrayList<String> subsets, int n)
{
    if (n==1)
    {
        subsets.add("0");
        subsets.add("1");
        return;
    }
    recursiveBitPatterns(subsets, n-1);
    int asize = subsets.size();
    for(int i=0; i<asize; i++)
    {
        String nsub = subsets.get(i);
        subsets.set(i, "0" + nsub);
        subsets.add("1" + nsub);
    }
}