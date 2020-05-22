public int[] insert(int[] src, int value)
{
    int[] dest = new int[src.length + 1];
    dest[0] = value;
    for (int i=0; i<src.length; i++)
    {
        dest[i+1] = src[i];
    }
    return dest;
}